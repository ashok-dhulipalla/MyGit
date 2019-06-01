package com.ashok.grids;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Procedure {

	private static String gridName="";
	private static String gridColumns="";
	private static String masterColumns="";
	private static String masterNames="";
	private static int masterId = 0;
	private static int unique= 665;
	public static void main(String[] args) throws IOException
	{

		BufferedWriter out= null;
		BufferedWriter allout=null;
		/*		String grids="NetAnoCityGrid\n" + 
				"NetAnoPincodeGrid\n" + 
				"NetAnoSalesGrid\n" + 
				"NetAnoStateGrid\n" + 
				"NetAnoDealerGrid\n" + 
				"NetAnoFlagGrid\n" + 
				"NPAAnoCityGrid\n" + 
				"NPAAnoPincodeGrid\n" + 
				"NPAAnoSalesGrid\n" + 
				"NPAAnoStateGrid\n" + 
				"NPAAnoDealerGrid\n" + 
				"NPAAnoFlagGrid\n" + 
				"PoorCollectionGrid\n" + 
				"GrowthAnoCityGrid\n" + 
				"GrowthAnoPincodeGrid\n" + 
				"GrowthAnoSalesGrid\n" + 
				"GrowthAnoStateGrid\n" + 
				"GrowthAnoDealerGrid\n" + 
				"GrowthAnoFlagGrid\n" + 
				"SGCityGrid\n" + 
				"SGPincodeGrid\n" + 
				"SGSalesGrid\n" + 
				"SGStateGrid\n" + 
				"SGDealerGrid\n" + 
				"SGFlagGrid\n" + 
				"UnsustainedGrowthGrid";*/
		String grids="NetNSBSalesGrid\n" + 
				"NetNSCityGrid\n" + 
				"NetNSStateGrid\n" + 
				"NetNSBPincodeGrid\n" + 
				"NPABCityGrid\n" + 
				"NPABPincodeGrid\n" + 
				"GSBStateGrid\n" + 
				"BetterNetCityGrid\n" + 
				"BetterNetPincodeGrid\n" + 
				"BetterNetSalesGrid\n" + 
				"BetterNetStateGrid\n" + 
				"BetterNetDealerGrid\n" + 
				"BetterNetFlagGrid\n" + 
				"NetAnoCityGrid\n" + 
				"NetAnoPincodeGrid\n" + 
				"NetAnoSalesGrid\n" + 
				"NetAnoStateGrid\n" + 
				"NetAnoDealerGrid\n" + 
				"NetAnoFlagGrid\n" + 
				"NPAAnoCityGrid\n" + 
				"NPAAnoPincodeGrid\n" + 
				"NPAAnoSalesGrid\n" + 
				"NPAAnoStateGrid\n" + 
				"NPAAnoDealerGrid\n" + 
				"NPAAnoFlagGrid\n" + 
				"PoorCollectionGrid\n" + 
				"GrowthAnoCityGrid\n" + 
				"GrowthAnoPincodeGrid\n" + 
				"GrowthAnoSalesGrid\n" + 
				"GrowthAnoStateGrid\n" + 
				"GrowthAnoDealerGrid\n" + 
				"GrowthAnoFlagGrid\n" + 
				"SGCityGrid\n" + 
				"SGPincodeGrid\n" + 
				"SGSalesGrid\n" + 
				"SGStateGrid\n" + 
				"SGDealerGrid\n" + 
				"SGFlagGrid\n" + 
				"UnsustainedGrowthGrid";
		String[] gridslist = grids.split("\n");
		
/*		for(int gridNum= 0,select= 103; select < 142;select++,gridNum++)
		{
			if(select == 116 || select == 104 || select == 107 || select == 110)
			{
				city(gridslist[gridNum], select);
			}
			else if(select == 117 || select == 106 || select == 108 || select == 111)
			{
				pincode(gridslist[gridNum], select);

			}
			else if(select == 118 || select == 103 || select == 112)
			{
				sales(gridslist[gridNum], select);

			}
			else if(select == 119 || select == 105 || select == 109 || select == 113)
			{
				state(gridslist[gridNum], select);

			}
			else if(select == 120 || select == 114)
			{
				dealer(gridslist[gridNum], select);

			}
			else if(select == 121 || select == 115)
			{
				if(select == 121)
					flag(gridslist[gridNum], select, "net_ano_");
				else if(select == 115)
					flag(gridslist[gridNum], select, "better_net_");
			}
			else if(select == 122)
			{
				city(gridslist[gridNum], select);
			}
			else if(select == 123)
			{
				pincode(gridslist[gridNum], select);

			}
			else if(select == 124)
			{
				sales(gridslist[gridNum], select);
			}
			else if(select == 125)
			{
				state(gridslist[gridNum], select);

			}
			else if(select == 126)
			{
				dealer(gridslist[gridNum], select);
			}
			else if(select == 127)
			{
				flag(gridslist[gridNum], select, "npa_ano_");
			}
			else if(select == 128)
			{
				gridName="PoorCollectionGrid"; 
				gridColumns="net_ano_flag_code\n" + 
						"net_ano_flag_name\n" + 
						"npa_ano_flag_code\n" + 
						"npa_ano_flag_name";
				masterColumns="bucket_code\n" + 
						"bucket_name\n" + 
						"bucket_code\n" + 
						"bucket_name";
				masterNames="CombiBucket\n" + 
						"CombiBucket\n" + 
						"CombiBucket\n" + 
						"CombiBucket";
				masterId= select;
			}
			else if(select == 129)
			{
				city(gridslist[gridNum], select);
			}
			else if(select == 130)
			{
				pincode(gridslist[gridNum], select);
			}
			else if(select == 131)
			{
				sales(gridslist[gridNum], select);
			}
			else if(select == 132)
			{
				state(gridslist[gridNum], select);
			}
			else if(select == 133)
			{
				dealer(gridslist[gridNum], select);
			}
			else if(select == 134)
			{
				flag(gridslist[gridNum], select, "growth_ano_");
			}
			else if(select == 135)
			{
				city(gridslist[gridNum], select);
			}
			else if(select == 136)
			{
				pincode(gridslist[gridNum], select);
			}
			else if(select == 137)
			{
				sales(gridslist[gridNum], select);
			}
			else if(select == 138)
			{
				state(gridslist[gridNum], select);
			}
			else if(select == 139)
			{
				dealer(gridslist[gridNum], select);
			}
			else if(select == 140)
			{
				flag(gridslist[gridNum], select, "sg_");
			}
			else if(select == 141)
			{
				gridName="UnsustainedGrowthGrid"; 
				gridColumns="growth_ano_flag_code\n" + 
						"growth_ano_flag_name\n" + 
						"slow_growth_flag_code\n" + 
						"slow_growth_flag_name\n" + 
						"net_ano_flag_code\n" + 
						"net_ano_flag_name";
				masterColumns="bucket_code\n" + 
						"bucket_name\n" + 
						"bucket_code\n" + 
						"bucket_name\n" + 
						"bucket_code\n" + 
						"bucket_name";
				masterNames="CombiBucket\n" + 
						"CombiBucket\n" + 
						"CombiBucket\n" + 
						"CombiBucket\n" + 
						"CombiBucket\n" + 
						"CombiBucket";
				masterId= select;
			}

			out = new BufferedWriter(new FileWriter("/home/ashok/My work/GRIDS/newGrids/"+"UPLOAD_"+gridName.toUpperCase()+"STG"+".sql"));
			allout = new BufferedWriter(new FileWriter("/home/ashok/My work/GRIDS/newGrids/all/uploads.sql",true));
			String procedure= getProcedure(gridName,gridColumns,masterColumns,masterNames);
			//System.out.println(procedure);
			out.write(procedure);
			out.flush();
			out.close();
			allout.append(procedure);
			allout.flush();
			allout.close();

			allout = new BufferedWriter(new FileWriter("/home/ashok/My work/GRIDS/newGrids/all/stagingTables.sql",true));
			String table= getStagingTable(gridName,gridColumns);
			//System.out.println(table);
			allout.append(table);
			allout.flush();
			allout.close();

			out = new BufferedWriter(new FileWriter("/home/ashok/My work/GRIDS/newGrids/COPY_"+gridName.toUpperCase()+"_VERSION.sql"));
			allout = new BufferedWriter(new FileWriter("/home/ashok/My work/GRIDS/newGrids/all/copies.sql",true));
			String copy= getCopyProcedure(gridName,gridColumns);
			//System.out.println(copy);
			out.write(copy);
			out.flush();
			out.close();
			allout.append(copy);
			allout.flush();
			allout.close();
			allout = new BufferedWriter(new FileWriter("/home/ashok/My work/GRIDS/newGrids/all/gridVersion.sql",true));
			String addInGridVersion=addGridVersion();
			allout.append(addInGridVersion);
			allout.flush();
			allout.close();

			out = new BufferedWriter(new FileWriter("/home/ashok/My work/GRIDS/newGrids/"+gridName.toUpperCase()+"_template.xml"));
			allout = new BufferedWriter(new FileWriter("/home/ashok/My work/GRIDS/newGrids/all/templates.xml",true));
			String template=getTemplate(gridName,gridColumns,masterNames);
			out.write(template);
			out.flush();
			out.close();
			allout.append(template);
			allout.flush();
			allout.close();

			out = new BufferedWriter(new FileWriter("/home/ashok/My work/GRIDS/newGrids/all/entities.sql",true));
			String entity= getEntity(gridName,masterId);
			//System.out.println(entity);
			out.append(entity);
			out.flush();
			out.close();

			out = new BufferedWriter(new FileWriter("/home/ashok/My work/GRIDS/newGrids/all/views.sql",true));
			String view= getView(gridName, gridColumns);
			//System.out.println(view);
			out.append(view);
			out.flush();
			out.close();

			out = new BufferedWriter(new FileWriter("/home/ashok/My work/GRIDS/newGrids/all/entitiesForRoles.sql",true));
			String roles= getEntityRoles(gridName);
			//System.out.println(view);
			out.append(roles);
			out.flush();
			out.close();

						out = new BufferedWriter(new FileWriter("/home/ashok/My work/GRIDS/newGrids/all/purge.sql"));
			String purge="";
			for(int p=132193;p <= 132218;p++)
				purge+="( purgeentity id = "+p+" )\n";
			System.out.println(purge);
			out.append(purge);
			out.flush();
			out.close();
			
			out = new BufferedWriter(new FileWriter("/home/ashok/My work/GRIDS/newGrids/all/updateEntities.sql",true));
			String updateentities=getUpdateentities(gridName,masterId);
			System.out.println(updateentities);
			out.append(updateentities);
			out.flush();
			out.close();
			
			out = new BufferedWriter(new FileWriter("/home/ashok/My work/GRIDS/newGrids/config/columnDetails.txt",true));
			String columnDetail=getColumnDetail(gridName,select);
			System.out.println(columnDetail);
			out.append(columnDetail);
			out.flush();
			out.close();


		}*/
/*		gridName="LTVRestrictionGrid"; 
		gridColumns="make_code\n" + 
				"make_name\n" + 
				"branch_code\n" + 
				"branch_name\n" + 
				"dealer_code\n" + 
				"dealer_name";
		masterColumns="asset_make_code\n" + 
				"asset_make_name\n" + 
				"branch_code\n" + 
				"branch_name\n" + 
				"dealer_code\n" + 
				"dealer_name";
		masterNames="AssetMake\n" + 
				"AssetMake\n" + 
				"Branch\n" + 
				"Branch\n" + 
				"Dealer\n" + 
				"Dealer";
		masterId= 143;*/
		
		/*gridName="NegativeAreaGrid"; 
		gridColumns="pin_code_code\n" + 
				"pin_code";
		masterColumns="pin_code_code\n" + 
				"pin_code_name";
		masterNames="Pincode\n" + 
				"Pincode";
		masterId= 144;*/
		
		gridName="BrokerLTVRestrictGrid"; 
		gridColumns="broker_code\n" + 
				"broker_name";
		masterColumns="dsa_code\n" + 
				"dsa_name";
		masterNames="DSA\n" + 
				"DSA";
		masterId= 150;
		
		out = new BufferedWriter(new FileWriter("/home/ashok/My work/GRIDS/newGrids/"+"UPLOAD_"+gridName.toUpperCase()+"STG"+".sql"));
		allout = new BufferedWriter(new FileWriter("/home/ashok/My work/GRIDS/newGrids/all/uploads.sql",true));
		String procedure= getProcedure(gridName,gridColumns,masterColumns,masterNames);
		System.out.println(procedure);
		out.write(procedure);
		out.flush();
		out.close();
		allout.append(procedure);
		allout.flush();
		allout.close();

		allout = new BufferedWriter(new FileWriter("/home/ashok/My work/GRIDS/newGrids/all/stagingTables.sql",true));
		String table= getStagingTable(gridName,gridColumns);
		System.out.println(table);
		allout.append(table);
		allout.flush();
		allout.close();

		out = new BufferedWriter(new FileWriter("/home/ashok/My work/GRIDS/newGrids/COPY_"+gridName.toUpperCase()+"_VERSION.sql"));
		allout = new BufferedWriter(new FileWriter("/home/ashok/My work/GRIDS/newGrids/all/copies.sql",true));
		String copy= getCopyProcedure(gridName,gridColumns);
		System.out.println(copy);
		out.write(copy);
		out.flush();
		out.close();
		allout.append(copy);
		allout.flush();
		allout.close();
		allout = new BufferedWriter(new FileWriter("/home/ashok/My work/GRIDS/newGrids/all/gridVersion.sql",true));
		String addInGridVersion=addGridVersion();
		allout.append(addInGridVersion);
		allout.flush();
		allout.close();

		out = new BufferedWriter(new FileWriter("/home/ashok/My work/GRIDS/newGrids/"+gridName.toUpperCase()+"_template.xml"));
		allout = new BufferedWriter(new FileWriter("/home/ashok/My work/GRIDS/newGrids/all/templates.xml",true));
		String template=getTemplate(gridName,gridColumns,masterNames);
		out.write(template);
		out.flush();
		out.close();
		allout.append(template);
		allout.flush();
		allout.close();

		out = new BufferedWriter(new FileWriter("/home/ashok/My work/GRIDS/newGrids/all/entities.sql",true));
		String entity= getEntity(gridName,masterId);
		System.out.println(entity);
		out.append(entity);
		out.flush();
		out.close();

		out = new BufferedWriter(new FileWriter("/home/ashok/My work/GRIDS/newGrids/all/views.sql",true));
		String view= getView(gridName, gridColumns);
		System.out.println(view);
		out.append(view);
		out.flush();
		out.close();
		
		out = new BufferedWriter(new FileWriter("/home/ashok/My work/GRIDS/newGrids/all/entitiesForRoles.sql",true));
		String roles= getEntityRoles(gridName);
		System.out.println(view);
		out.append(roles);
		out.flush();
		out.close();
	}
	private static String getUpdateentities(String gridName, int masterId) {
		String updateEntities="( updateentity ( category = \"GridMaster\" master_id = "+masterId+" detail_structure_name = \""+gridName+"\" ) )\n\n";
		return updateEntities;
	}
	private static String getColumnDetail(String gridName,int select) {
		String[] gridcolumnslist = gridColumns.split("\n");
		String columnDetail="";
		for(int i= 0;i < gridcolumnslist.length;)
		{
			columnDetail+=unique+++"-"+select+"-"+spacesForGridNames(ShortCutReplace(gridName))+"-"+gridcolumnslist[i]+"-0-NULL-NULL-Input\n";
			i+= 2;
		}
		columnDetail+=unique+++"-"+select+"-"+spacesForGridNames(ShortCutReplace(gridName))+"-yesno_code-0-NULL-NULL-Output\n";
		return columnDetail;
	}
	private static String getEntityRoles(String gridName) {
		int roleid=103;
		String roles="( addentity  ( category = \"RolePAMObjectLinks\" C = 0 D = 0 R = 1 U = 0 allowed = 1 approval_rights = 0 executable = \"NULL\" include_in_menu = 0 pam_object = \""+gridName+"\" pam_type = \"BO\" roleid = "+roleid+++" skip_partner_filter = \"NULL\" uimodel = \""+gridName+"DefaultUI\" uimodel_add = \""+gridName+"UI\" ) )\n\n";
		roles+="( addentity  ( category = \"RolePAMObjectLinks\" C = 0 D = 0 R = 1 U = 0 allowed = 1 approval_rights = 0 executable = \"NULL\" include_in_menu = 0 pam_object = \""+gridName+"\" pam_type = \"BO\" roleid = "+roleid+" skip_partner_filter = \"NULL\" uimodel = \""+gridName+"DefaultUI\" uimodel_add = \""+gridName+"UI\" ) )\n\n";
		return roles;
	}
	private static String getEntity(String gridName, int i) {
		String entity="( addentity ( category = \"GridMaster\" master_id = \""+i+"\" master_name = \""+spacesForGridNames(ShortCutReplace(gridName))+"\" description = \""+spacesForGridNames(ShortCutReplace(gridName))+" For TW\" product_code = \"1\" product_id = \"2WH\" product_name = \"TWO WHEELER NEW\" version_ffn = \"1\" detail_structure_name = \""+gridName+"\" business_status = \"Active\" created_by = \"System\" creation_date = \"2018:9:2:0:0:0\" ir_approval_status = \"approved\" ir_last_approved_by = \"NULL\" ir_last_approved_date = \"NULL\" last_modified_by = \"System\" url = \"NULL\" last_modified_date = \"2015:9:2:0:0:0\" lcm_status = \"A\" owner = \"a\" owner_name = \"Common\" read_only = \"1\" is_active = \"1\" active_filter = \"1\" ) )\n\n";
		return entity;
	}
	private static String getView(String gridName,String gridColumns) {
		String[] gridcolumnslist = gridColumns.split("\n");
		String view="create view "+gridName+" as \n" + 
				"SELECT EntityId, EntityVersion, Active, LastModifiedTime, business_status, created_by, creation_date, last_modified_by, last_modified_date, lcm_status, owner, owner_name, read_only, unique_id, url, ir_last_approved_by, ir_approval_status, ir_last_approved_date, master_id, master_name, version_id, product_code, product_name";
		view+=getAllColumns(gridcolumnslist).toLowerCase();
		view+=", yesno_code, yesno_name, gridversion_eid from sangam_mdm."+gridName+";\n"
				+ "GO\n";
		return view;
	}
	private static String getTemplate(String gridName, String gridColumns, String masterNames) {
		String[] gridcolumnslist = gridColumns.split("\n");
		String[] masternameslist = masterNames.split("\n");
		String template="<template name=\""+gridName+"\">\n" + 
				"    <datasource name=\""+gridName+"Staging\" type=\"TABLE\" />\n" + 
				"	<roles>GRID</roles>\n" + 
				"    <upload-processor >com.hl.tools.uploadutil.io.CSVFileUploadProcessor</upload-processor>\n" + 
				"    <download-processor>com.hl.tools.uploadutil.io.CSVFileDownloadProcessor</download-processor>\n" + 
				"	<pre-processor></pre-processor>\n" + 
				"	<custom-processor processing-class=\"com.hl.cms.portal.common.fileupload.CustomDBPostProcessor\" validation-proc=\"UPLOAD_"+gridName.toUpperCase()+"STG\"  completion-proc=\"DELETE_GRIDSTAGING("+gridName+"Staging)\">com.hl.tools.uploadutil.core.DBUploadBatchDefaultProcessor</custom-processor>\n" + 
				"    <result-output  batch-result=\"true\" error=\"ERROR_MESSAGE\" status=\"STATUS\">C:/Bulkupload/Sangam/MDM/uploaded/"+gridName+"</result-output>\n" + 
				"	<template-output>C:/Bulkupload/Sangam/MDM/template</template-output>\n" + 
				"    <action>validateadd</action>\n" + 
				"    <startline>3</startline>\n" + 
				"    <endline>25000</endline>\n";
		template+="	<generated-query><![CDATA[ INSERT INTO "+gridName+"Staging (version_id";
		template+=getCodeColumns(gridcolumnslist);
		template+=", yesno_code, valid_version_id) VALUES ( {1}";
		int j=2;
		for(int i=0;i < gridcolumnslist.length;)
		{
			template+=",{"+j+"}";
			i+= 2;
			j+= 2;
		}
		template+=", {"+j+"}, '{valid_version_id}' )]]>\n" + 
				"	</generated-query>\n";
		template+="	<select-query><![CDATA[ SELECT version_id AS \"1\"";
		j=2;
		for(int i=0;i < gridcolumnslist.length;i++)
		{
			template+=", "+gridcolumnslist[i]+" AS \""+j+++"\"";
		}
		template+=", yesno_code AS \""+j+++"\", yesno_name AS \""+j+++"\", unique_id AS \""+j+++"\" FROM "+gridName+" where version_id = '{version_id}' ]]></select-query>\n";
		template+="    <properties>\n" + 
				"		<property sequence=\"1\">\n" + 
				"			<property-type></property-type>\n" + 
				"			<mandatory>true</mandatory>\n" + 
				"			<property-name>version_id</property-name>\n" + 
				"			<display-name>Version Id</display-name>\n" + 
				"			<default-value></default-value>\n" + 
				"			<possible-value></possible-value>\n" + 
				"			<datatype>String</datatype>\n" + 
				"			<format></format>\n" + 
				"			<populate>true</populate>\n" + 
				"		</property>\n";
		j= 2;
		for(int i=0;i < gridcolumnslist.length;)
		{
			System.out.println(capsFirst(gridcolumnslist[i]));
			template+="		<property sequence=\""+j+++"\">\n" + 
					"			<property-type></property-type>\n" + 
					"			<mandatory>true</mandatory>\n" + 
					"			<property-name>"+gridcolumnslist[i]+"</property-name>\n" + 
					"			<display-name>"+capsFirst(gridcolumnslist[i++])+"</display-name>\n" + 
					"			<default-value></default-value>\n" + 
					"			<possible-value></possible-value>\n" + 
					"			<datatype>Integer</datatype>\n" + 
					"			<format></format>\n" + 
					"			<populate>true</populate>\n" + 
					"		</property>\n" + 
					"		<property sequence=\""+j+++"\">\n" + 
					"			<property-type>ignore</property-type>\n" + 
					"			<mandatory>false</mandatory>\n" + 
					"			<property-name>"+gridcolumnslist[i]+"</property-name>\n" + 
					"			<display-name>"+capsFirst(gridcolumnslist[i++])+"</display-name>\n" + 					"			<default-value></default-value>\n" + 
					"			<possible-value></possible-value>\n" + 
					"			<datatype>String</datatype>\n" + 
					"			<format></format>\n" + 
					"			<populate>true</populate>\n" + 
					"		</property>\n";

		}
		template+="		<property sequence=\""+j+++"\">\n" + 
				"			<property-type></property-type>\n" + 
				"			<mandatory>true</mandatory>\n" + 
				"			<property-name>yesno_code</property-name>\n" + 
				"			<display-name>Combination Bucket Code</display-name>\n" + 
				"			<default-value></default-value>\n" + 
				"			<possible-value></possible-value>\n" + 
				"			<datatype>Integer</datatype>\n" + 
				"			<format></format>\n" + 
				"			<populate>true</populate>\n" + 
				"		</property>\n" + 
				"		<property sequence=\""+j+++"\">\n" + 
				"			<property-type>ignore</property-type>\n" + 
				"			<mandatory>false</mandatory>\n" + 
				"			<property-name>yesno_name</property-name>\n" + 
				"			<display-name>Combination Bucket Name</display-name>\n" + 
				"			<default-value></default-value>\n" + 
				"			<possible-value></possible-value>\n" + 
				"			<datatype>String</datatype>\n" + 
				"			<format></format>\n" + 
				"			<populate>true</populate>\n" + 
				"		</property>\n" + 
				"		";
		template+="		<property sequence=\""+j+"\">\n" + 
				"			<property-type>ignore</property-type>\n" + 
				"			<mandatory>false</mandatory>\n" + 
				"			<property-name>unique_id</property-name>\n" + 
				"			<display-name>Unique Id</display-name>\n" + 
				"			<default-value></default-value>\n" + 
				"			<possible-value></possible-value>\n" + 
				"			<datatype>Integer</datatype>\n" + 
				"			<format></format>\n" + 
				"			<populate>true</populate>\n" + 
				"		</property>\n" + 
				"	</properties>\n" + 
				"</template>\n";
		return template;
	}
	private static String getCopyProcedure(String gridName, String gridColumns) throws IOException {



		String[] gridcolumnslist = gridColumns.split("\n");
		String copy="CREATE PROCEDURE COPY_"+gridName.toUpperCase()+"_VERSION(\n" + 
				"	@source_version_id VARCHAR (4000),\n" + 
				"	@target_version_id VARCHAR (4000),\n" + 
				"	@target_gridversion_eid  NUMERIC (18)\n" + 
				")\n" + 
				"AS\n" + 
				"BEGIN"+
				"\n" + 
				"";
		copy+="	-- In the Staging table generate batch records to be processed\n" + 
				"	INSERT INTO "+gridName+"Staging \n" + 
				"		(MASTER_ID, MASTER_NAME, VERSION_ID, GRIDVERSION_EID, PRODUCT_CODE, PRODUCT_NAME";

		copy+= getAllColumns(gridcolumnslist);

		copy+=", yesno_code, yesno_name) \n" + 
				"		SELECT MASTER_ID, MASTER_NAME, @target_version_id, @target_gridversion_eid, PRODUCT_CODE, PRODUCT_NAME";

		copy+= getAllColumns(gridcolumnslist);

		copy+=", yesno_code, yesno_name FROM "+gridName+" \n" + 
				"		WHERE VERSION_ID = @source_version_id; \n" + 
				"\n" + 
				"";
		copy+="	-- Insert records into the Main table\n" + 
				"	INSERT INTO "+gridName+" \n" + 
				"		(UNIQUE_ID, MASTER_ID, MASTER_NAME, VERSION_ID, GRIDVERSION_EID, PRODUCT_CODE, PRODUCT_NAME";

		copy+= getAllColumns(gridcolumnslist);

		copy+=",yesno_code, yesno_name, ENTITYID, ENTITYVERSION, ACTIVE, LASTMODIFIEDTIME, BUSINESS_STATUS, CREATED_BY, CREATION_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, OWNER, OWNER_NAME, READ_ONLY, URL, IR_LAST_APPROVED_BY, IR_APPROVAL_STATUS, IR_LAST_APPROVED_DATE, LCM_STATUS) \n" + 
				"		SELECT UNIQUE_ID, MASTER_ID, MASTER_NAME, VERSION_ID, GRIDVERSION_EID, PRODUCT_CODE, PRODUCT_NAME";

		copy+= getAllColumns(gridcolumnslist);

		copy+=", yesno_code, yesno_name, UNIQUE_ID, '0', 'A', 'NULL', 'Active', 'System', GETDATE(), 'System', GETDATE(), 'a', 'Common', '1', 'NULL', 'NULL', 'approved', null, null FROM "+gridName+"Staging; \n" + 
				"\n" + 
				"	-- Delete the batch records from the Staging table\n" + 
				"	DELETE FROM "+gridName+"Staging\n"+ 
				"END;\n"+ 
				"GO\n";
		return copy;
	}
	private static String getStagingTable(String gridName, String gridColumns) {

		String[] gridcolumnslist = gridColumns.split("\n");
		String tables="CREATE TABLE \""+gridName+"Staging\" \n" + 
				"	(\"unique_id\" NUMERIC (18) IDENTITY(1, 1) NOT NULL, \n" + 
				"	\"master_id\" NUMERIC (18),\n" + 
				"	\"master_name\" VARCHAR (4000),\n" + 
				"	\"version_id\" VARCHAR (4000),\n" + 
				"	\"gridversion_eid\" NUMERIC (18),\n" + 
				"	\"product_code\" VARCHAR (4000),\n" + 
				"	\"product_name\" VARCHAR (4000),\n\n";
		for(int i=0;i < gridcolumnslist.length;)
		{
			tables+="	\""+gridcolumnslist[i++]+"\" NUMERIC (18),\n" + 
					"	\""+gridcolumnslist[i++]+"\" VARCHAR (4000),\n";
		}
		tables+="\n	\"yesno_code\" NUMERIC (18),\n" + 
				"	\"yesno_name\" VARCHAR (4000),\n" + 
				"	\"status\" VARCHAR (100),\n" + 
				"	\"error_message\" VARCHAR (4000),\n" + 
				"	\"valid_version_id\" VARCHAR(4000),\n" + 
				"	PRIMARY KEY (unique_id)\n" + 
				"	);\n"+ 
				"GO\n";	
		return tables;
	}
	private static String getProcedure(String gridName, String gridColumns, String masterColumns,String masterNames)
	{


		String[] gridcolumnslist = gridColumns.split("\n");
		String[] mastercolumnslist = masterColumns.split("\n");
		String[] masternameslist = masterNames.split("\n");
		String procedure="CREATE PROCEDURE UPLOAD_"+gridName.toUpperCase()+"STG\n" + 
				"AS\n" + 
				"\n" + 
				"DECLARE @master_source VARCHAR(100);\n" + 
				"DECLARE @product_category_code  VARCHAR(100);\n" + 
				"BEGIN"+
				"\n" + 
				"SELECT TOP 1 @master_source = p.master_source, @product_category_code = p.product_category_code \n" + 
				"FROM GridVersion g, "+gridName+"Staging stg, Product p \n" + 
				"WHERE p.product_code = g.product_code AND g.version_id = stg.version_id;\n" + 
				"\n" + 
				
				"-- Update Status to Pending\n" + 
				
				"UPDATE "+gridName+"Staging \n" + 
				"SET STATUS = 'PENDING';\n" + 
				"\n" + 
				"\n" + 
				
				"-- Validate Data\n" + 
				
				"UPDATE "+gridName+"Staging  \n" + 
				"SET status = 'ERROR', \n" + 
				"	error_message = ISNULL(error_message,'') + 'Version Id is mandatory,' \n" + 
				"WHERE version_id IS NULL;\n" + 
				"\n" + 
				
				"IF (select count(DISTINCT version_id) from "+gridName+"Staging) > 1 \n" + 
				"BEGIN \n" + 
				"	UPDATE "+gridName+"Staging \n" + 
				"	SET status = 'ERROR', \n" + 
				"		error_message = ISNULL(error_message,'') + 'Version Id should be same for every record,' ;\n" + 
				"END \n" + 
				"\n" + 
				
				"UPDATE "+gridName+"Staging  \n" + 
				"SET status = 'ERROR', \n" + 
				"	error_message = ISNULL(error_message,'') + 'Invalid Version Id,' \n" + 
				"WHERE version_id <> valid_version_id;\n" + 
				"\n" + 
				
				"UPDATE crcgs \n" + 
				"SET crcgs.status = 'ERROR', \n" + 
				"	crcgs.error_message = ISNULL(crcgs.error_message,'') + 'Grid Version should be in Draft status,' \n" + 
				"FROM "+gridName+"Staging crcgs \n" + 
				"INNER JOIN GridVersion gv on crcgs.version_id = gv.version_id \n" + 
				"WHERE gv.business_status <> 'Draft';\n" + 
				"";
		
		procedure+="-- Input Properties Validation Starts\n";

		for(int i= 0;i < gridcolumnslist.length;)
		{
			procedure+="UPDATE "+gridName+"Staging  \n" + 
					"SET status = 'ERROR', \n" + 
					"	error_message = ISNULL(error_message,'') + '"+capsFirst(gridcolumnslist[i])+" is mandatory,' \n" + 
					"WHERE "+gridcolumnslist[i]+" IS NULL;		\n" + 
					"\n" + 
					
					"UPDATE arcgs \n" + 
					"SET arcgs.status = 'ERROR', \n" + 
					"	arcgs.error_message = ISNULL(arcgs.error_message,'') + '"+capsFirst(gridcolumnslist[i])+" should be present in "+masternameslist[i]+" Master,' \n" + 
					"FROM "+gridName+"Staging arcgs\n";
			if(!masternameslist[i].equals("YesNo"))
				procedure+="WHERE arcgs."+gridcolumnslist[i]+" IS NOT NULL AND NOT EXISTS ( select "+mastercolumnslist[i]+" from "+masternameslist[i]+" where ( ((master_source = @master_source AND product_category_code = @product_category_code)OR (any_flag = 1)) and "+mastercolumnslist[i]+" = arcgs."+gridcolumnslist[i]+" /*and is_active = 1*/ ));\n";
			else
				procedure+="WHERE arcgs."+gridcolumnslist[i]+" IS NOT NULL AND NOT EXISTS ( select yesno_code from YesNo where  "+mastercolumnslist[i]+" = arcgs."+gridcolumnslist[i]+" /*and is_active = 1*/ );\n";
			i+= 2;

		}
		procedure+="\n\n-- Input Properties Validation Ends\n";

		procedure+="\n-- Output Properties Validation Starts\n";

		procedure+="UPDATE "+gridName+"Staging  \n" + 
				"SET status = 'ERROR', \n" + 
				"	error_message = ISNULL(error_message,'') + 'Combination Bucket Code is mandatory,' \n" + 
				"WHERE yesno_code IS NULL;		\n" + 
				"\n" + 
				
				"UPDATE arcgs \n" + 
				"SET arcgs.status = 'ERROR', \n" + 
				"	arcgs.error_message = ISNULL(arcgs.error_message,'') + 'Combination Bucket Code should be present in YesNo Master,' \n" + 
				"FROM "+gridName+"Staging arcgs\n" + 
				"WHERE arcgs.yesno_code IS NOT NULL AND NOT EXISTS ( select yesno_code from YesNo where  yesno_code = arcgs.yesno_code /*and is_active = 1*/ );\n" + 
				"\n" + 
				
				"UPDATE arcgs \n" + 
				"SET arcgs.status = 'ERROR', \n" + 
				"	arcgs.error_message = ISNULL(arcgs.error_message,'') + 'Combination Bucket Code can not be -1,' \n" + 
				"FROM "+gridName+"Staging arcgs\n" + 
				"WHERE arcgs.yesno_code = -1;\n";

		procedure+="-- Output Properties Validation Ends\n";

		procedure+="UPDATE crcgs1 \n" + 
				"SET crcgs1.status = 'ERROR', \n" + 
				"	crcgs1.error_message = ISNULL(crcgs1.error_message,'') + '";
		if(masternameslist.length > 2)
		{
			procedure+="Combination of "+capsFirst(gridcolumnslist[0]);
		}
		else
		{
			procedure+=capsFirst(gridcolumnslist[0]);
		}
		for(int i= 2;i < masternameslist.length;)
		{
			procedure+=","+capsFirst(gridcolumnslist[i]);
			i+= 2;
		}
		procedure+=" should be unique for a Version Id,' \n" + 
				"FROM "+gridName+"Staging crcgs1 \n" + 
				"JOIN \n" + 
				"(	SELECT version_id";

		procedure+=getCodeColumns(gridcolumnslist);

		procedure+="	FROM "+gridName+"Staging \n" + 
				"    GROUP BY version_id";
		for(int i=0;i < gridcolumnslist.length;)
		{
			procedure+=","+gridcolumnslist[i];
			i+= 2;
		}
		procedure+="    HAVING COUNT(*) > 1 \n" + 
				") crcgs2 \n" + 
				"ON \n" + 
				"crcgs1.version_id = crcgs2.version_id";
		for(int i=0;i < gridcolumnslist.length;)
		{
			procedure+=" AND\n";
			procedure+="crcgs1."+gridcolumnslist[i]+" = crcgs2."+gridcolumnslist[i];
			i+= 2;
		}
		procedure+=";\n";
		procedure+="\n-- Update Status to Success\n" + 
				"UPDATE "+gridName+"Staging \n" + 
				"SET STATUS = 'SUCCESS' \n" + 
				"WHERE STATUS = 'PENDING';\n";
		
		procedure+="IF NOT EXISTS (select unique_id from "+gridName+"Staging where status = 'ERROR') \n" + 
				"BEGIN \n" + 
				"	-- Update remaining columns as per masters\n" + 
				"	UPDATE crcgs \n" + 
				"	SET crcgs.master_id = gv.master_id, \n" + 
				"		crcgs.master_name = gv.master_name, \n" + 
				"		crcgs.gridversion_eid = gv.entityid, \n" + 
				"		crcgs.product_code = gv.product_code, \n" + 
				"		crcgs.product_name = gv.product_name,\n";
		int j=1;
		for(int i=1;i < gridcolumnslist.length;)
		{
			procedure+="		crcgs."+gridcolumnslist[i]+" = buck"+j+"."+mastercolumnslist[i]+",\n";
			i+= 2;
			j++;
		}
		procedure+="		crcgs.yesno_name = buck"+j+".yesno_name \n";
		procedure+="	FROM "+gridName+"Staging crcgs \n" + 
				"	INNER JOIN GridVersion gv on crcgs.version_id = gv.version_id  \n";
		j=1;
		for(int i=0;i < gridcolumnslist.length;)
		{
			procedure+="	INNER JOIN "+masternameslist[i]+" buck"+j+" on crcgs."+gridcolumnslist[i]+" = buck"+j+"."+mastercolumnslist[i]+"\n";
			i+= 2;
			j++;
		}
		procedure+="	INNER JOIN YesNo buck"+j+" on crcgs.yesno_code = buck"+j+".yesno_code\n" + 
				"	WHERE crcgs.status = 'SUCCESS';\n";

		procedure+="\n-- Cleanup all Main table records for this version_id\n" + 
				"DELETE FROM "+gridName+" WHERE VERSION_ID IN ( select top 1 VERSION_ID from "+gridName+"Staging )\n";

		procedure+="\n	-- Insert success records into Main table\n" + 
				"	INSERT INTO "+gridName+" \n" + 
				"		(UNIQUE_ID, MASTER_ID, MASTER_NAME, VERSION_ID, GRIDVERSION_EID, PRODUCT_CODE, PRODUCT_NAME";

		procedure+= getAllColumns(gridcolumnslist);

		procedure+=",yesno_code, yesno_name, ENTITYID, ENTITYVERSION, ACTIVE, LASTMODIFIEDTIME, BUSINESS_STATUS, CREATED_BY, CREATION_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, OWNER, OWNER_NAME, READ_ONLY, URL, IR_LAST_APPROVED_BY, IR_APPROVAL_STATUS, IR_LAST_APPROVED_DATE, LCM_STATUS) \n";

		procedure+="	SELECT UNIQUE_ID, MASTER_ID, MASTER_NAME, VERSION_ID, GRIDVERSION_EID, PRODUCT_CODE, PRODUCT_NAME";

		procedure+= getAllColumns(gridcolumnslist);

		procedure+=",yesno_code, yesno_name, UNIQUE_ID, '0', 'A', 'NULL', 'Active', 'System', GETDATE(), 'System', GETDATE(), 'a', 'Common', '1', 'NULL', 'NULL', 'approved', null, null FROM "+gridName+"Staging \n" + 
				"		WHERE STATUS = 'SUCCESS'; \n" + 
				"END\n"+
				"END;\n"+
				"GO\n";
		return procedure;

	}
	private static String addGridVersion() {
		return 	"	IF @detail_structure_name = '"+gridName+"' \n" + 
				"	BEGIN \n" + 
				"		EXEC COPY_"+gridName.toUpperCase()+"_VERSION @source_version_id, @target_version_id, @target_gridversion_eid;\n" + 
				"	END ;\n\n";
	}
	private static String getAllColumns(String[] gridcolumnslist)
	{
		String columns="";
		for(int i=0;i < gridcolumnslist.length;i++)
		{
			columns+=","+gridcolumnslist[i].toUpperCase();
		}
		return columns;
	}

	private static String getCodeColumns(String[] gridcolumnslist)
	{
		String columns="";
		for(int i=0;i < gridcolumnslist.length;)
		{
			columns+=","+gridcolumnslist[i];
			i+= 2;
		}
		return columns;
	}

	private static String capsFirst(String str) {
		String[] words = str.split("_");
		StringBuilder ret = new StringBuilder();
		for(int i = 0; i < words.length; i++) {
			ret.append(Character.toUpperCase(words[i].charAt(0)));
			ret.append(words[i].substring(1));
			if(i < words.length - 1) {
				ret.append(' ');
			}
		}
		String res= ret.toString();
		res= res.replaceAll("Ano", "Anomalies");
		res= res.replaceAll("Dealer", "Supplier");
		res= res.replaceAll("Sg ", "Slow Growth ");
		res= res.replaceAll("Npa ", "NPA ");
		return res;
	}
	private static String ShortCutReplace(String masterName)
	{
		return masterName.replaceAll("Ano", "Anomalies").replaceAll("Dealer", "Supplier").replaceAll("SG", "SlowGrowth");
	}

	private static String spacesForGridNames(String str)
	{
		String res="";
		int i=1;
		StringBuilder sb= new StringBuilder(str);
		res+= sb.charAt(0);
		for(i=2;i < sb.length();i++)
		{
			char c= sb.charAt(i-1);
			if(Character.isLowerCase(c) && Character.isUpperCase(sb.charAt(i)))
				res+= c+" ";
			else if(Character.isUpperCase(c) && Character.isLowerCase(sb.charAt(i)))
			{
				res= res.trim();
				res+= " "+c;
			}
			else
				res+= c;
		}
		res+= sb.charAt(i-1);
		return res;
	}
	private static void city(String grid, int id)
	{
		gridName=grid; 
		gridColumns="city_code\n" + 
				"city_name";
		masterColumns="city_taluka_code\n" + 
				"city_taluka_name";
		masterNames="CityTaluka\n" + 
				"CityTaluka";
		masterId= id;
	}
	private static void state(String grid, int id)
	{
		gridName=grid; 
		gridColumns="state_code\n" + 
				"state_name";
		masterColumns="state_code\n" + 
				"state_name";
		masterNames="State\n" + 
				"State";
		masterId= id;
	}
	private static void sales(String grid, int id)
	{
		gridName=grid; 
		gridColumns="sales_code\n" + 
				"sales_name";
		masterColumns="sales_code\n" + 
				"sales_name";
		masterNames="SalesHierarchy\n" + 
				"SalesHierarchy";
		masterId= id;
	}
	private static void dealer(String grid, int id)
	{
		gridName=grid; 
		gridColumns="dealer_code\n" + 
				"dealer_name";
		masterColumns="dealer_code\n" + 
				"dealer_name";
		masterNames="Dealer\n" + 
				"Dealer";
		masterId= id;
	}
	private static void pincode(String grid, int id)
	{
		gridName=grid; 
		gridColumns="pin_code_code\n" + 
				"pin_code";
		masterColumns="pin_code_code\n" + 
				"pin_code";
		masterNames="PinCode\n" + 
				"PinCode";
		masterId= id;
	}
	private static void flag(String grid, int id, String prefix)
	{
		gridName=grid; 
		gridColumns=prefix+"pincode_code\n" + 
				prefix+"pincode_name\n" + 
				prefix+"sales_code\n" + 
				prefix+"sales_name\n" + 
				prefix+"dealer_code\n" + 
				prefix+"dealer_name\n" + 
				prefix+"city_code\n" + 
				prefix+"city_name\n" + 
				prefix+"state_code\n" + 
				prefix+"state_name";
		masterColumns="bucket_code\n" + 
				"bucket_name\n" + 
				"bucket_code\n" + 
				"bucket_name\n" + 
				"bucket_code\n" + 
				"bucket_name\n" + 
				"bucket_code\n" + 
				"bucket_name\n" + 
				"bucket_code\n" + 
				"bucket_name";
		masterNames="CombiBucket\n" + 
				"CombiBucket\n" + 
				"CombiBucket\n" + 
				"CombiBucket\n" + 
				"CombiBucket\n" + 
				"CombiBucket\n" + 
				"CombiBucket\n" + 
				"CombiBucket\n" + 
				"CombiBucket\n" + 
				"CombiBucket";
		masterId= id;
	}
}
