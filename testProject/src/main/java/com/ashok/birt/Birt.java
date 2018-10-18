package com.ashok.birt;

import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EXCELRenderOption;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.HTMLServerImageHandler;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.PDFRenderOption;

import com.ashok.exception.MyUtilException;

public class Birt {

	private EngineConfig config;
	private IReportEngine engine;
	private IRunAndRenderTask task;

	private void createConfig()
	{
		EngineConfig config = new EngineConfig( );			
		config.setLogConfig("/home/ashok/birt/log", java.util.logging.Level.FINEST);
		
		this.config= config;
	}
	private void createEngine() throws BirtException
	{
		createConfig();
		Platform.startup( config );
		IReportEngineFactory factory = (IReportEngineFactory) Platform.createFactoryObject( IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY );
		IReportEngine engine = factory.createReportEngine( config );
		
		this.engine= engine;
	}
	public IRunAndRenderTask createTask(String rptFile) throws BirtException {
		createEngine();
		
		IReportRunnable design = engine.openReportDesign(rptFile); 
		IRunAndRenderTask task = engine.createRunAndRenderTask(design);
		this.task= task;
		return task;
	}
	public IRunAndRenderTask getTask() {
		return task;
	}
	
	public void setRenderOption(RenderOption option, String outFile) throws MyUtilException
	{
		if(option.equals(RenderOption.html))
		{
			if(!outFile.endsWith(".html"))
				throw new MyUtilException("OutPut File name should end with .html");
			HTMLRenderOption optionHtml = new HTMLRenderOption();	
			optionHtml.setOutputFileName(outFile);
			optionHtml.setOutputFormat("html");
			task.setRenderOption(optionHtml);
		}
		else if(option.equals(RenderOption.pdf))
		{
			if(!outFile.endsWith(".pdf"))
				throw new MyUtilException("OutPut File name should end with .pdf");
			PDFRenderOption optionsPdf = new PDFRenderOption();
			optionsPdf.setOutputFileName(outFile);
			optionsPdf.setOutputFormat("pdf");
			task.setRenderOption(optionsPdf);
		}
		else if(option.equals(RenderOption.xls))
		{
			if(!outFile.endsWith(".xls"))
				throw new MyUtilException("OutPut File name should end with .xls");
			
			EXCELRenderOption optionsXlsx = new EXCELRenderOption();
			optionsXlsx.setOutputFileName(outFile);
			optionsXlsx.setOutputFormat("xls");
			optionsXlsx.setImageHandler(new HTMLServerImageHandler());
			task.setRenderOption(optionsXlsx);
		}
		
	}
	public void runTask() throws EngineException {
		try {
			task.run();
		} catch (EngineException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			Platform.shutdown( );
			task.close();
			engine.destroy();
		}

	}
	
}
