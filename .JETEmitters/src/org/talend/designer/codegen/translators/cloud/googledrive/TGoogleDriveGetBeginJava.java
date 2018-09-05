package org.talend.designer.codegen.translators.cloud.googledrive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.codegen.config.NodeParamsHelper;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TGoogleDriveGetBeginJava
{
  protected static String nl;
  public static synchronized TGoogleDriveGetBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGoogleDriveGetBeginJava result = new TGoogleDriveGetBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t    " + NL + "String ";
  protected final String TEXT_2 = "_outputFileExt = \"\";" + NL + "java.util.Map<String, String[]> ";
  protected final String TEXT_3 = "_exportMapping = new java.util.HashMap<String, String[]>();";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = "_exportMapping.put(\"application/vnd.google-apps.document\", new String[] {\"";
  protected final String TEXT_6 = "\", \"";
  protected final String TEXT_7 = "\"});";
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = "_exportMapping.put(\"application/vnd.google-apps.drawing\", new String[] {\"";
  protected final String TEXT_10 = "\", \"";
  protected final String TEXT_11 = "\"});";
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = "_exportMapping.put(\"application/vnd.google-apps.presentation\", new String[] {\"";
  protected final String TEXT_14 = "\", \"";
  protected final String TEXT_15 = "\"});";
  protected final String TEXT_16 = NL;
  protected final String TEXT_17 = "_exportMapping.put(\"application/vnd.google-apps.spreadsheet\", new String[] {\"";
  protected final String TEXT_18 = "\", \"";
  protected final String TEXT_19 = "\"});" + NL + "" + NL + "com.google.api.services.drive.Drive ";
  protected final String TEXT_20 = "_client;";
  protected final String TEXT_21 = NL + "{";
  protected final String TEXT_22 = NL + NL + "\tjavax.net.ssl.TrustManagerFactory tmf = javax.net.ssl.TrustManagerFactory" + NL + "\t\t.getInstance(javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm());" + NL + "\t" + NL + "\tjava.io.FileInputStream fis = new java.io.FileInputStream(";
  protected final String TEXT_23 = ");" + NL + "\tjava.security.KeyStore ks = java.security.KeyStore.getInstance(java.security.KeyStore.getDefaultType());";
  protected final String TEXT_24 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_25 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_28 = " = ";
  protected final String TEXT_29 = "; ";
  protected final String TEXT_30 = NL + "                       " + NL + "\tks.load(fis, decryptedPassword_";
  protected final String TEXT_31 = ".toCharArray());" + NL + "\tfis.close();" + NL + "\ttmf.init(ks);" + NL + "\tjavax.net.ssl.SSLContext sslContext = javax.net.ssl.SSLContext.getInstance(";
  protected final String TEXT_32 = ");" + NL + "\t\tsslContext.init(null, tmf.getTrustManagers(), new java.security.SecureRandom());";
  protected final String TEXT_33 = NL + "\tcom.google.api.client.http.HttpTransport httpTransport = new com.google.api.client.http.javanet.NetHttpTransport.Builder()";
  protected final String TEXT_34 = NL + "\t\t.setProxy(new java.net.Proxy(java.net.Proxy.Type.HTTP, java.net.InetSocketAddress.createUnresolved(";
  protected final String TEXT_35 = ", ";
  protected final String TEXT_36 = ")))";
  protected final String TEXT_37 = NL + "\t\t.setSslSocketFactory(sslContext.getSocketFactory())";
  protected final String TEXT_38 = NL + "\t\t.build();" + NL + "" + NL + "\tcom.google.api.client.googleapis.auth.oauth2.GoogleCredential credential = new com.google.api.client.googleapis.auth.oauth2.GoogleCredential().setAccessToken(";
  protected final String TEXT_39 = ");" + NL + "\t";
  protected final String TEXT_40 = "_client = new  com.google.api.services.drive.Drive.Builder(httpTransport, new com.google.api.client.json.jackson2.JacksonFactory(), credential)" + NL + "\t\t.setApplicationName(";
  protected final String TEXT_41 = "+\" (GPN:Talend)\").build();" + NL + "}";
  protected final String TEXT_42 = NL;
  protected final String TEXT_43 = "_client = (com.google.api.services.drive.Drive)globalMap.get(";
  protected final String TEXT_44 = ");";
  protected final String TEXT_45 = NL + "\t\tcom.google.api.services.drive.Drive.Files.List ";
  protected final String TEXT_46 = "_listRequest =  ";
  protected final String TEXT_47 = "_client.files().list();" + NL + "\t\t";
  protected final String TEXT_48 = "_listRequest.setQ(\"trashed = false and title = '\" + ";
  protected final String TEXT_49 = " + \"' and mimeType != 'application/vnd.google-apps.folder'\");" + NL + "\t\tcom.google.api.services.drive.model.FileList ";
  protected final String TEXT_50 = "_files = ";
  protected final String TEXT_51 = "_listRequest.execute();" + NL + "\t\tif (";
  protected final String TEXT_52 = "_files.getItems().size() > 1)" + NL + "\t\t{" + NL + "\t\t\tthrow new Exception(\"More than one file found with name \\\"\" + ";
  protected final String TEXT_53 = " + \"\\\" \");" + NL + "\t\t}" + NL + "\t\telse if (";
  protected final String TEXT_54 = "_files.getItems().isEmpty())" + NL + "\t\t{" + NL + "\t\t\tthrow new Exception(\"No file found with name \\\"\" + ";
  protected final String TEXT_55 = " + \"\\\" \");" + NL + "\t\t}" + NL + "\t\telse" + NL + "\t\t{" + NL + "\t\t\tString ";
  protected final String TEXT_56 = "_fileId = ";
  protected final String TEXT_57 = "_files.getItems().get(0).getId();" + NL + "\t\t\tcom.google.api.services.drive.model.File ";
  protected final String TEXT_58 = "_file = ";
  protected final String TEXT_59 = "_client.files().get(";
  protected final String TEXT_60 = "_fileId).execute();" + NL + "\t\t\t" + NL + "\t\t\tString ";
  protected final String TEXT_61 = "_downloadUrl = ";
  protected final String TEXT_62 = "_file.getDownloadUrl();" + NL + "" + NL + "\t\t\t// Google document can't be downloaded, download url is null, they must be exported" + NL + "\t\t\tif(";
  protected final String TEXT_63 = "_downloadUrl == null) {" + NL + "\t\t\t\tjava.util.Map<String, String> ";
  protected final String TEXT_64 = "_exportLinks = ";
  protected final String TEXT_65 = "_file.getExportLinks();" + NL + "\t\t\t\t" + NL + "                if(";
  protected final String TEXT_66 = "_exportLinks != null) {" + NL + "                    String[] ";
  protected final String TEXT_67 = "_exportInfo = ";
  protected final String TEXT_68 = "_exportMapping.get(";
  protected final String TEXT_69 = "_file.getMimeType()); " + NL + "                    String ";
  protected final String TEXT_70 = "_exportTo = ";
  protected final String TEXT_71 = "_exportInfo[0];" + NL + "                    String ext = ";
  protected final String TEXT_72 = "_exportInfo[1];" + NL + "                    ";
  protected final String TEXT_73 = NL + "                    ";
  protected final String TEXT_74 = "_downloadUrl = ";
  protected final String TEXT_75 = "_exportLinks.get(";
  protected final String TEXT_76 = "_exportTo);";
  protected final String TEXT_77 = "              ";
  protected final String TEXT_78 = NL + "                    ";
  protected final String TEXT_79 = "_outputFileExt = ext;";
  protected final String TEXT_80 = NL + "                }" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\t// If the document has no download url and can't be exported" + NL + "\t\t\tif(";
  protected final String TEXT_81 = "_downloadUrl != null) {" + NL + "\t\t\t    com.google.api.client.http.HttpResponse resp = ";
  protected final String TEXT_82 = "_client.getRequestFactory().buildGetRequest(new com.google.api.client.http.GenericUrl(";
  protected final String TEXT_83 = "_downloadUrl)).execute();";
  protected final String TEXT_84 = NL + "            String ";
  protected final String TEXT_85 = "_outputFileName = ";
  protected final String TEXT_86 = ";";
  protected final String TEXT_87 = NL + "                ";
  protected final String TEXT_88 = "_outputFileName = ";
  protected final String TEXT_89 = "_outputFileName+((";
  protected final String TEXT_90 = "_outputFileName.endsWith(";
  protected final String TEXT_91 = "_outputFileExt)) ? \"\" : ";
  protected final String TEXT_92 = "_outputFileExt);";
  protected final String TEXT_93 = NL + "    \t\t\tjava.io.File ";
  protected final String TEXT_94 = "_outputFile = new java.io.File(";
  protected final String TEXT_95 = "_outputFileName);" + NL + "    \t\t\tjava.io.FileOutputStream ";
  protected final String TEXT_96 = "_outputStream = new java.io.FileOutputStream(";
  protected final String TEXT_97 = "_outputFile);" + NL + "    \t\t\tresp.download(";
  protected final String TEXT_98 = "_outputStream);";
  protected final String TEXT_99 = NL + "\t\t\t    ";
  protected final String TEXT_100 = ".content = ";
  protected final String TEXT_101 = NL + "\t\t\t\t    new java.io.FileInputStream(";
  protected final String TEXT_102 = "_outputFile);";
  protected final String TEXT_103 = NL + "\t\t\t\t    resp.getContent();";
  protected final String TEXT_104 = NL + "\t\t\t}" + NL + "\t\t\telse {" + NL + "\t\t\t    ";
  protected final String TEXT_105 = ".content = null;" + NL + "\t\t\t}" + NL + "\t\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
		CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
		INode node = (INode)codeGenArgument.getArgument();
		String cid = node.getUniqueName();
		NodeParamsHelper helper = new NodeParamsHelper(node);

		boolean useExistingConn = helper.getBoolParam("__USE_EXISTING_CONNECTION__");
		String connection = helper.getStringParam("__CONNECTION__");
	    String connectionKey = "\"conn_" + connection+"\"";

		String fileName = helper.getStringParam("__FILE_NAME__");

		boolean storeToLocal = helper.getBoolParam("__STORE_TO_LOCAL__");
		String outputFile = helper.getStringParam("__OUTPUT__");
		boolean addExt = helper.getBoolParam("__OUTPUT_EXT__"); 

		boolean dieOnError = helper.getBoolParam("__DIE_ON_ERROR__");
		
		String exportDocumentType = helper.getStringParam("__EXPORT_DOCUMENT__");
		String exportDrawType = helper.getStringParam("__EXPORT_DRAWING__");
		String exportPresentationType = helper.getStringParam("__EXPORT_PRESENTATION__");
		String exportSpreadSheetType = helper.getStringParam("__EXPORT_SPREADSHEET__");
		
		Map<String, String> mapExtension = new HashMap<String, String>();
		mapExtension.put("application/epub+zip", ".zip");
		mapExtension.put("application/pdf", ".pdf");
		mapExtension.put("application/rtf", ".rtf");
		mapExtension.put("application/vnd.oasis.opendocument.presentation", ".odp");
		mapExtension.put("application/vnd.oasis.opendocument.spreadsheet", ".ods");
		mapExtension.put("application/vnd.oasis.opendocument.text", ".odt");
		mapExtension.put("application/vnd.openxmlformats-officedocument.presentationml.presentation", ".pptx");
		mapExtension.put("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", ".xlsx");
		mapExtension.put("application/vnd.openxmlformats-officedocument.wordprocessingml.document", ".docx");
		mapExtension.put("application/x-vnd.oasis.opendocument.spreadshee", ".ods");
		mapExtension.put("application/zip", ".zip");
		mapExtension.put("image/jpeg", ".jpg");
		mapExtension.put("image/png", ".png");
		mapExtension.put("image/svg+xml", ".svg");
		mapExtension.put("text/csv", ".csv");
		mapExtension.put("text/html", ".html");
		mapExtension.put("text/plain", ".txt");
		mapExtension.put("text/tab-separated-values", ".csv");
		
		String exportDocumentExt = mapExtension.get(exportDocumentType);
		String exportDrawExt = mapExtension.get(exportDrawType);
		String exportPresentationExt = mapExtension.get(exportPresentationType);
		String exportSpreadSheetExt = mapExtension.get(exportSpreadSheetType);

        String dataOutputConnection = null;
	    
		List< ? extends IConnection> outputConnections = node.getOutgoingSortedConnections();
	    for(IConnection conn : outputConnections) {
	        if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	        	dataOutputConnection = conn.getName();
	        	break;
	        } // if(conn) end
	    } // for(conns) end

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(exportDocumentType);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(exportDocumentExt);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(exportDrawType);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(exportDrawExt);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(exportPresentationType);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(exportPresentationExt);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(exportSpreadSheetType);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(exportSpreadSheetExt);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
		if(!useExistingConn){

    stringBuffer.append(TEXT_21);
    
	    	boolean useSSL = helper.getBoolParam("__USE_SSL__");
	    	boolean useProxy = helper.getBoolParam("__USE_PROXY__");
	    	if(useSSL) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(helper.getStringParam("__SSL_TRUST_STORE__"));
    stringBuffer.append(TEXT_23);
    String passwordFieldName = "__SSL_TRUST_STORE_PASSWORD__";
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_26);
    } else {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(helper.getStringParam("__SSL_ALGORITHM__"));
    stringBuffer.append(TEXT_32);
    
			}

    stringBuffer.append(TEXT_33);
    
			if(useProxy) {
				String proxyHost = helper.getStringParam("__PROXY_HOST__");
				String proxyPort = helper.getStringParam("__PROXY_PORT__");

    stringBuffer.append(TEXT_34);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(proxyPort);
    stringBuffer.append(TEXT_36);
    
			}if(useSSL) {

    stringBuffer.append(TEXT_37);
    
			}

    stringBuffer.append(TEXT_38);
    stringBuffer.append(helper.getStringParam("__ACCESS_TOKEN__"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(helper.getStringParam("__APPLICATION_NAME__"));
    stringBuffer.append(TEXT_41);
    
		}else {

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(connectionKey);
    stringBuffer.append(TEXT_44);
    
		}

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
                if(addExt) {

    stringBuffer.append(TEXT_77);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    
                }

    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
		if (storeToLocal){

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(outputFile);
    stringBuffer.append(TEXT_86);
    
            if(addExt) {

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    
            }

    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
		}
		if(dataOutputConnection != null){

    stringBuffer.append(TEXT_99);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_100);
    
			if(storeToLocal){

    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    
			}else{

    stringBuffer.append(TEXT_103);
    
			}
		}

    stringBuffer.append(TEXT_104);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_105);
    return stringBuffer.toString();
  }
}
