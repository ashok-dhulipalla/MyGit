package com.ashok.preSancTransfm;

import java.io.IOException;

public class PreSanctionTransform {
	
	private static String mainTableName=null;
	private static String mainTableColumns=null;
	private static String masterName=null;
	private static String masterColumnNames=null;
	public static void main(String[] args) throws IOException
	{
		//PostAssetDetail
		/*		mainTableName="PostAssetDetail";
		mainTableColumns="manu_id\n" + 
				"manu_code\n" + 
				"manu_name";
		masterName="AssetManufacturer";
		masterColumnNames="manufacturer_id\n" + 
				"manufacturer_code\n" + 
				"manufacturer_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="make_id\n" + 
				"make_code\n" + 
				"make_name";
		masterName="AssetMake";
		masterColumnNames="asset_make_id\n" + 
				"asset_make_code\n" + 
				"asset_make_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="model_id\n" + 
				"model_code\n" + 
				"model_name";
		masterName="AssetModel";
		masterColumnNames="asset_model_id\n" + 
				"asset_model_code\n" + 
				"asset_model_no";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);*/
		
/*		mainTableColumns="dealer_id\n" + 
				"dealer_code\n" + 
				"dealer_name";
		masterName="Dealer";
		masterColumnNames="dealer_id\n" + 
				"dealer_code\n" + 
				"dealer_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);*/
		
		//DisbursementDetail
/*		mainTableName="DisbursementDetail";
		mainTableColumns="payment_mode_id\n" + 
				"payment_mode_code\n" + 
				"payment_mode_name";
		masterName="PaymentMode";
		masterColumnNames="payment_mode_id\n" + 
				"payment_mode_code\n" + 
				"payment_mode_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="disbursal_mode_id\n" + 
				"disbursal_mode_code\n" + 
				"disbursal_mode_name";
		masterName="DisbursementMode";
		masterColumnNames="disb_mode_id\n" + 
				"disb_mode_code\n" + 
				"disb_mode_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);*/
		
		//LifeInsDetail
/*		mainTableName="LifeInsDetail";
		mainTableColumns="insurance_company_id\n" + 
				"insurance_company_code\n" + 
				"insurance_company_name";
		masterName="CLICompany";
		masterColumnNames="cli_company_id\n" + 
				"cli_company_code\n" + 
				"cli_company_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="relation_with_nominee_id\n" + 
				"rel_with_nominee_code\n" + 
				"rel_with_nominee_name";
		masterName="RelationshipType";
		masterColumnNames="relation_type_id\n" + 
				"relation_type_code\n" + 
				"relation_type_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="gender_id\n" + 
				"gender_code\n" + 
				"gender_name";
		masterName="Gender";
		masterColumnNames="gender_id\n" + 
				"gender_code\n" + 
				"gender_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);*/
		
		//AssetInsDetail
/*		mainTableName="AssetInsDetail";
		mainTableColumns="insurance_company_id\n" + 
				"insurance_company_code\n" + 
				"insurance_company_name";
		masterName="AssetInsCompany";
		masterColumnNames="insurer_id\n" + 
				"insurer_code\n" + 
				"insurer_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);*/
		
		//InstrumentDetail
/*		mainTableName="InstrumentDetail";
		mainTableColumns="instru_type_id\n" + 
				"instru_type_code\n" + 
				"instru_type_name";
		masterName="InstrumentType";
		masterColumnNames="instru_type_id\n" + 
				"instru_type_code\n" + 
				"instru_type_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="city_id\n" + 
				"city_name";
		masterName="PDCCity";
		masterColumnNames="city_id\n" + 
				"city_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="bank_id\n" + 
				"bank_name";
		masterName="PDCBank";
		masterColumnNames="bank_id\n" + 
				"bank_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="bank_branch_id\n" + 
				"bank_branch_name";
		masterName="PDCBankBranch";
		masterColumnNames="bank_branch_id\n" + 
				"bank_branch_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="pdc_by_id\n" + 
				"pdc_by_code\n" + 
				"pdc_by_name";
		masterName="PDCBy";
		masterColumnNames="pdc_by_id\n" + 
				"pdc_by_code\n" + 
				"pdc_by_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="dest_bank_acc_type_id\n" + 
				"dest_bank_acc_type_code\n" + 
				"dest_bank_acc_type_name";
		masterName="AccountType";
		masterColumnNames="account_type_id\n" + 
				"account_type_code\n" + 
				"account_type_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="pdc_type_id\n" + 
				"pdc_type_code\n" + 
				"pdc_type_name";
		masterName="PDCType";
		masterColumnNames="pdc_type_id\n" + 
				"pdc_type_code\n" + 
				"pdc_type_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="cheque_type_id\n" + 
				"cheque_type_code\n" + 
				"cheque_type_name";
		masterName="ChequeType";
		masterColumnNames="cheque_type_id\n" + 
				"cheque_type_code\n" + 
				"cheque_type_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);*/
		
		//ChargeDetail
/*		mainTableName="ChargeDetail";
		mainTableColumns="charge_id\n" + 
				"charge_code\n" + 
				"module_id\n" + 
				"txn_id\n" + 
				"txn_type\n" + 
				"bp_id\n" + 
				"bp_type\n" + 
				"advice_flag\n" + 
				"charge_code_id\n" + 
				"rcpt_pmn_flag\n" + 
				"currency_id\n" + 
				"tax_applicable";
		masterName="Charge";
		masterColumnNames="charge_id\n" + 
				"charge_code\n" + 
				"module_id\n" + 
				"txn_id\n" + 
				"txn_type\n" + 
				"bp_id\n" + 
				"bp_type\n" + 
				"advice_flag\n" + 
				"charge_code_id\n" + 
				"rcpt_pmn_flag\n" + 
				"currency_id\n" + 
				"tax_appl_flg";
		getUpdatedStringWithCase(mainTableName, mainTableColumns, masterName, masterColumnNames);*/
		
		//PostIMD
/*		mainTableName="PostIMD";
		mainTableColumns="drawn_on_id\n" + 
				"drawn_on_name";
		masterName="PDCBank";
		masterColumnNames="bank_id\n" + 
				"bank_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="city_id\n" + 
				"city_name";
		masterName="PDCCity";
		masterColumnNames="city_id\n" + 
				"city_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		//OpsAddress
		mainTableName="OpsAddress";
		mainTableColumns="address_type_id\n" + 
				"address_type_code\n" + 
				"address_type_name";
		masterName="AddressType";
		masterColumnNames="address_type_id\n" + 
				"address_type_code\n" + 
				"address_type_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="ownership_status_id\n" + 
				"ownership_status_code\n" + 
				"ownership_status_name";
		masterName="OwnerType";
		masterColumnNames="owner_type_id\n" + 
				"owner_type_code\n" + 
				"owner_type_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="state_id\n" + 
				"state_code\n" + 
				"state_name";
		masterName="State";
		masterColumnNames="state_id\n" + 
				"state_code\n" + 
				"state_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="city_id\n" + 
				"city_code\n" + 
				"city_name";
		masterName="CityTaluka";
		masterColumnNames="city_taluka_id\n" + 
				"city_taluka_code\n" + 
				"city_taluka_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="pin_code_id\n" + 
				"pin_code_code\n" + 
				"pin_code_name";
		masterName="PinCode";
		masterColumnNames="pin_code_id\n" + 
				"pin_code_code\n" + 
				"pin_code";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);*/
		
		//OpsInstrumentDetail
/*		mainTableName="OpsInstrumentDetail";
		mainTableColumns="instru_type_id\n" + 
				"instru_type_code\n" + 
				"instru_type_name";
		masterName="InstrumentType";
		masterColumnNames="instru_type_id\n" + 
				"instru_type_code\n" + 
				"instru_type_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="city_id\n" + 
				"city_name";
		masterName="PDCCity";
		masterColumnNames="city_id\n" + 
				"city_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="bank_id\n" + 
				"bank_name";
		masterName="PDCBank";
		masterColumnNames="bank_id\n" + 
				"bank_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="bank_branch_id\n" + 
				"bank_branch_name";
		masterName="PDCBankBranch";
		masterColumnNames="bank_branch_id\n" + 
				"bank_branch_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="pdc_by_id\n" + 
				"pdc_by_code\n" + 
				"pdc_by_name";
		masterName="PDCBy";
		masterColumnNames="pdc_by_id\n" + 
				"pdc_by_code\n" + 
				"pdc_by_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="dest_bank_acc_type_id\n" + 
				"dest_bank_acc_type_code\n" + 
				"dest_bank_acc_type_name";
		accountType();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="pdc_type_id\n" + 
				"pdc_type_code\n" + 
				"pdc_type_name";
		masterName="PDCType";
		masterColumnNames="pdc_type_id\n" + 
				"pdc_type_code\n" + 
				"pdc_type_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="cheque_type_id\n" + 
				"cheque_type_code\n" + 
				"cheque_type_name";
		masterName="ChequeType";
		masterColumnNames="cheque_type_id\n" + 
				"cheque_type_code\n" + 
				"cheque_type_name";
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);*/
		
		//OpsBankDetail
/*		mainTableName="OpsBankDetail";
		mainTableColumns="bank_id\n" + 
				"bank_code\n" + 
				"bank_name";
		bank();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="account_type_id\n" + 
				"account_type_code\n" + 
				"account_type_name";
		accountType();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);*/
		
		//OpsDisbursmentDetails
/*		mainTableName="OpsDisbursmentDetails";
		mainTableColumns="payment_mode_id\n" + 
				"payment_mode_code\n" + 
				"payment_mode_name";
		paymentMode();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="disbursal_mode_id\n" + 
				"disbursal_mode_code\n" + 
				"disbursal_mode_name";
		disbursementMode();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		//OpsDocumentDetail
		mainTableName="OpsDocumentDetail";
		mainTableColumns="doc_id\n" + 
				"doc_code\n" + 
				"doc_name";
		docHeader();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="parent_doc_id\n" + 
				"parent_doc_code\n" + 
				"parent_doc_name";
		parentDocHeader();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);*/
		
/*		mainTableName="Applicant";
		mainTableColumns="income_slab_id\n" + 
				"income_slab_code\n" + 
				"income_slab_name";
		incomeSlab();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);*/
		
/*		mainTableName="ApplicantINTGStatus";
		mainTableColumns="intg_id\n" + 
				"intg_code\n" + 
				"intg_name";
		intgMaster();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="intg_veri_error_id\n" + 
				"intg_veri_error_code\n" + 
				"intg_veri_error_name";
		errorMaster();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);*/
		
/*		mainTableName="UserProfile";
		mainTableColumns="user_type_id\n" + 
				"user_type_code\n" + 
				"user_type_name";
		userType();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="company_id\n" + 
				"company_code\n" + 
				"company_name";
		company();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="occupation_type_id\n" + 
				"occupation_type_code\n" + 
				"occupation_type_name";
		occupationType();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="relation_type_id\n" + 
				"relation_type_code\n" + 
				"relation_type_name";
		relationshipType();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);*/
		
/*		mainTableName="LoanAppSteps";
		mainTableColumns="step_id\n" + 
				"step_code\n" + 
				"step_name";
		uiStep();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);*/
		
/*		mainTableName="LoanAppTrail";
		mainTableColumns="activity_id\n" + 
				"activity_code\n" + 
				"activity_name";
		activity();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);*/
		
/*		mainTableName="UserAddress";
		mainTableColumns="address_type_id\n" + 
				"address_type_code\n" + 
				"address_type_name";
		addressType();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="state_id\n" + 
				"state_code\n" + 
				"state_name";
		state();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="city_id\n" + 
				"city_code\n" + 
				"city_name";
		cityTaluka();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="pin_code_id\n" + 
				"pin_code_code\n" + 
				"pin_code_name";
		pinCode();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
		mainTableColumns="country_id\n" + 
				"country_code\n" + 
				"country_name";
		country();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);*/
		
/*		mainTableName="BankAccountInfo";
		mainTableColumns="bank_id\n" + 
				"bank_code\n" + 
				"bank_name";
		pdcBank();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		mainTableColumns="ifsc_code\n" + 
				"bank_branch_id\n" + 
				"bank_branch_name\n" + 
				"pdc_city_id\n" + 
				"micr_code";
		PDCMICR();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);*/
		
		mainTableName="BankAccountHistory";
		mainTableColumns="bank_id\n" + 
				"bank_code\n" + 
				"bank_name";
		pdcBank();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		mainTableColumns="ifsc_code\n" + 
				"bank_branch_id\n" + 
				"bank_branch_name\n" + 
				"pdc_city_id\n" + 
				"micr_code";
		PDCMICR();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		mainTableColumns="error_id\n" + 
				"error_code\n" + 
				"error_name";
		errorMaster();
		getUpdatedString(mainTableName, mainTableColumns, masterName, masterColumnNames);
		
	}
	private static void PDCMICR()
	{
		masterName="PDCMICR";
		masterColumnNames="ifsc_code\n" + 
				"bank_branch_id\n" + 
				"bank_branch_name\n" + 
				"city_id\n" + 
				"micr_code";
	}
	private static void pdcBank()
	{
		masterName="PDCBank";
		masterColumnNames="bank_id\n" + 
				"bank_code\n" + 
				"bank_name";
	}
	private static void activity()
	{
		masterName="Activity";
		masterColumnNames="activity_id\n" + 
				"activity_code\n" + 
				"activity_name";
	}
	private static void country()
	{
		masterName="Country";
		masterColumnNames="country_id\n" + 
				"country_code\n" + 
				"country_name";
	}
	private static void district()
	{
		masterName="District";
		masterColumnNames="district_id\n" + 
				"district_code\n" + 
				"district_name";
	}
	private static void pinCode()
	{
		masterName="PinCode";
		masterColumnNames="pin_code_id\n" + 
				"pin_code_code\n" + 
				"pin_code_name";
	}
	private static void cityTaluka()
	{
		masterName="CityTaluka";
		masterColumnNames="city_taluka_id\n" + 
				"city_taluka_code\n" + 
				"city_taluka_name";
	}
	private static void state()
	{
		masterName="State";
		masterColumnNames="state_id\n" + 
				"state_code\n" + 
				"state_name";
	}
	private static void addressType()
	{
		masterName="AddressType";
		masterColumnNames="address_type_id\n" + 
				"address_type_code\n" + 
				"address_type_name";
	}
	private static void uiStep()
	{
		masterName="UIStep";
		masterColumnNames="step_id\n" + 
				"step_code\n" + 
				"step_name";
	}
	private static void relationshipType()
	{
		masterName="RelationshipType";
		masterColumnNames="relation_type_id\n" + 
				"relation_type_code\n" + 
				"relation_type_name";
	}
	private static void occupationType()
	{
		masterName="OccupationType";
		masterColumnNames="occ_type_id\n" + 
				"occ_type_code\n" + 
				"occ_type_name";
	}
	private static void company()
	{
		masterName="Company";
		masterColumnNames="company_id\n" + 
				"company_code\n" + 
				"company_name";
	}
	private static void userType()
	{
		masterName="UserType";
		masterColumnNames="user_type_id\n" + 
				"user_type_code\n" + 
				"user_type_name";
	}
	private static void intgMaster()
	{
		masterName="IntgMaster";
		masterColumnNames="intg_id\n" + 
				"intg_code\n" + 
				"intg_name";
	}
	private static void errorMaster()
	{
		masterName="ErrorMaster";
		masterColumnNames="error_id\n" + 
				"error_code\n" + 
				"error_name";
	}
	private static void incomeSlab()
	{
		masterName="IncomeSlab";
		masterColumnNames="income_slab_id\n" + 
				"income_slab_code\n" + 
				"income_slab_name";
	}
	private static void accountType()
	{
		masterName="AccountType";
		masterColumnNames="account_type_id\n" + 
				"account_type_code\n" + 
				"account_type_name";
	}
	private static void bank()
	{
		masterName="Bank";
		masterColumnNames="bank_id\n" + 
				"bank_code\n" + 
				"bank_name";
	}
	private static void paymentMode()
	{
		masterName="PaymentMode";
		masterColumnNames="payment_mode_id\n" + 
				"payment_mode_code\n" + 
				"payment_mode_name";
	}
	private static void disbursementMode()
	{
		masterName="DisbursementMode";
		masterColumnNames="disb_mode_id\n" + 
				"disb_mode_code\n" + 
				"disb_mode_name";
	}
	private static void docHeader()
	{
		masterName="DocHeader";
		masterColumnNames="doc_id\n" + 
				"doc_code\n" + 
				"doc_name";
	}
	private static void parentDocHeader()
	{
		masterName="DocHeader";
		masterColumnNames="parent_doc_id\n" + 
				"parent_doc_code\n" + 
				"parent_doc_name";
	}
	private static void opsMaster()
	{
		masterName="OpsMaster";
		masterColumnNames="code\n" + 
				"name";
	}
	private static String getUpdatedString(String mainTableName,String mainTableColumns,String masterName,String masterColumnNames)
	{
		String[] mainColumnsList = mainTableColumns.split("\n");
		String[] masterColumnsList = masterColumnNames.split("\n");
		getValidateString(mainTableName,mainColumnsList[0],masterName,masterColumnsList[0]);
		String res= "	update "+mainTableName+" as main\n" + 
				"	set \n";
		for(int i= 1;i < mainColumnsList.length-1;i++)
		{
			res+= "	    "+mainColumnsList[i]+" = ref."+masterColumnsList[i]+", \n";
		}
		res+= "	    "+mainColumnsList[mainColumnsList.length-1]+" = ref."+masterColumnsList[mainColumnsList.length-1]+" \n";
		res+= "	from  "+masterName+" AS ref\n" + 
				"	where \n" + 
				"	 ref.is_active = 1\n" + 
				"	and main.app_id = par_app_id\n" + 
				"	and main.app_version_id = par_app_version_id\n" + 
				"	and main."+mainColumnsList[0]+" = ref."+masterColumnsList[0]+"\n" + 
				"	and LOWER(var_master_source) = LOWER(ref.master_source);\n\n";
		System.out.println(res);
		return res;
	}
	private static String getUpdatedStringWithCase(String mainTableName,String mainTableColumns,String masterName,String masterColumnNames)
	{
		
		String[] mainColumnsList = mainTableColumns.split("\n");
		String[] masterColumnsList = masterColumnNames.split("\n");
		getValidateString(mainTableName,mainColumnsList[0],masterName,masterColumnsList[0]);
		String res= "	update "+mainTableName+" as main\n" + 
				"	set \n";
		for(int i= 1;i < mainColumnsList.length-1;i++)
		{
			res+= "	    "+mainColumnsList[i]+" = case when main."+mainColumnsList[i]+" is null then ref."+masterColumnsList[i]+" else main."+mainColumnsList[i]+" end, \n";
		}
		res+= "	    "+mainColumnsList[mainColumnsList.length-1]+" = case when main."+mainColumnsList[mainColumnsList.length-1]+" is null then ref."+masterColumnsList[mainColumnsList.length-1]+" else main."+mainColumnsList[mainColumnsList.length-1]+" end \n";
		res+= "	from  "+masterName+" AS ref\n" + 
				"	where \n" + 
				"	 ref.is_active = 1\n" + 
				"	and main.app_id = par_app_id\n" + 
				"	and main.app_version_id = par_app_version_id\n" + 
				"	and main."+mainColumnsList[0]+" = ref."+masterColumnsList[0]+"\n" + 
				"	and LOWER(var_master_source) = LOWER(ref.master_source);\n\n";
		System.out.println(res);
		return res;
	}
	private static String getValidateString(String mainTableName, String mainColumn, String masterName, String masterColumn) {
		String res= "	select * from validate\n" + 
				"	(\n" + 
				"		'"+mainTableName+"', \n" + 
				"		'"+mainColumn+"',\n" + 
				"		'"+masterName+"', \n" + 
				"		'"+masterColumn+"', \n" + 
				"		par_app_id, \n" + 
				"		par_app_version_id,\n" + 
				"		null,\n" + 
				"		var_master_source\n" + 
				"	)\n" + 
				"	into var_is_valid, var_invalid_value;\n" + 
				"	\n" + 
				"	if var_is_valid = false\n" + 
				"	then\n" + 
				"		par_error_code := -5;\n" + 
				"		par_error_message := par_error_message || ' "+masterName+" with id '||var_invalid_value||' does not exist or is Inactive' || var_error_message_seperator;\n" + 
				"	end if;	\n\n";
		System.out.println(res);
		return res;
		
	}

}
