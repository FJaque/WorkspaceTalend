package org.talend.designer.codegen.translators.databases.ldap;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.utils.NodeUtil;

public class TLDAPAttributesInputBeginJava
{
  protected static String nl;
  public static synchronized TLDAPAttributesInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLDAPAttributesInputBeginJava result = new TLDAPAttributesInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.debug(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_7 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_8 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_11 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_13 = " - Written records count: \" + nb_line_";
  protected final String TEXT_14 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_16 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_18 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_19 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_21 = " - Writing the record \" + nb_line_";
  protected final String TEXT_22 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Processing the record \" + nb_line_";
  protected final String TEXT_25 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_27 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_28 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + " ";
  protected final String TEXT_30 = NL + "\t\t\t\tString baseDN_";
  protected final String TEXT_31 = " = \"\";";
  protected final String TEXT_32 = NL + "\t\t\t\t\tjava.util.Hashtable env_";
  protected final String TEXT_33 = " = new java.util.Hashtable();" + NL + "\t\t\t\t\tenv_";
  protected final String TEXT_34 = ".put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, \"com.sun.jndi.ldap.LdapCtxFactory\");" + NL + "\t\t\t\t\tenv_";
  protected final String TEXT_35 = ".put(javax.naming.Context.REFERRAL, \"";
  protected final String TEXT_36 = "\");" + NL + "\t\t\t\t\tenv_";
  protected final String TEXT_37 = ".put(\"java.naming.ldap.derefAliases\",\"";
  protected final String TEXT_38 = "\");" + NL + "\t\t\t\t\tenv_";
  protected final String TEXT_39 = ".put(javax.naming.Context.PROVIDER_URL, \"ldap://\"+";
  protected final String TEXT_40 = "+\":\"+";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = NL + "\t\t\t\t\t\tenv_";
  protected final String TEXT_43 = ".put(javax.naming.Context.SECURITY_PROTOCOL, \"ssl\");" + NL + "\t\t\t\t\t\tenv_";
  protected final String TEXT_44 = ".put(\"java.naming.ldap.factory.socket\", \"talend.ssl.AdvancedSocketFactory\");";
  protected final String TEXT_45 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_47 = " - Adnanced CA trusting all certs.\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\t\t\t\t\ttalend.ssl.AdvancedSocketFactory.alwaysTrust();";
  protected final String TEXT_49 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_51 = " - Advanced CA using a store CA file and Keystore password.\");" + NL + "\t\t\t\t\t\t\t\t\tlog.debug(\"Store CA : '\" + ";
  protected final String TEXT_52 = " + \"'.\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t\t\t\t\t\ttalend.ssl.AdvancedSocketFactory.setCertStorePath(";
  protected final String TEXT_54 = ");";
  protected final String TEXT_55 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_56 = NL + "                                    ";
  protected final String TEXT_57 = " " + NL + "                                    \tfinal String decryptedPwd_";
  protected final String TEXT_58 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_59 = ");";
  protected final String TEXT_60 = NL + "                                    \tfinal String decryptedPwd_";
  protected final String TEXT_61 = " = ";
  protected final String TEXT_62 = "; ";
  protected final String TEXT_63 = NL + NL + "\t\t\t\t\t\t\t\t\ttalend.ssl.AdvancedSocketFactory.setCertStorePassword(decryptedPwd_";
  protected final String TEXT_64 = ");";
  protected final String TEXT_65 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_66 = NL;
  protected final String TEXT_67 = NL + "\tlog.info(\"";
  protected final String TEXT_68 = " - Connection attempt to '\"+ ";
  protected final String TEXT_69 = " + \"'.\");";
  protected final String TEXT_70 = NL;
  protected final String TEXT_71 = NL + "\t";
  protected final String TEXT_72 = NL + "\tlog.info(\"";
  protected final String TEXT_73 = " - Authentication using username and password.\");" + NL + "\t";
  protected final String TEXT_74 = NL + "\t" + NL + "\t";
  protected final String TEXT_75 = NL + "  ";
  protected final String TEXT_76 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_77 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_78 = ");";
  protected final String TEXT_79 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_80 = " = ";
  protected final String TEXT_81 = "; ";
  protected final String TEXT_82 = NL;
  protected final String TEXT_83 = NL + "\t\tenv_";
  protected final String TEXT_84 = ".put(javax.naming.Context.SECURITY_AUTHENTICATION, \"simple\");// \"none\",\"simple\",\"strong\"";
  protected final String TEXT_85 = NL + "    env_";
  protected final String TEXT_86 = ".put(javax.naming.Context.SECURITY_PRINCIPAL, ";
  protected final String TEXT_87 = ");" + NL + "    env_";
  protected final String TEXT_88 = ".put(javax.naming.Context.SECURITY_CREDENTIALS, decryptedPassword_";
  protected final String TEXT_89 = ");";
  protected final String TEXT_90 = NL;
  protected final String TEXT_91 = "javax.naming.ldap.InitialLdapContext";
  protected final String TEXT_92 = " ctx_";
  protected final String TEXT_93 = " = new javax.naming.ldap.InitialLdapContext(env_";
  protected final String TEXT_94 = ", null);" + NL;
  protected final String TEXT_95 = NL + "\tjavax.naming.ldap.StartTlsRequest tldsReq_";
  protected final String TEXT_96 = " = new javax.naming.ldap.StartTlsRequest();" + NL + "  javax.naming.ldap.StartTlsResponse tls_";
  protected final String TEXT_97 = " =(javax.naming.ldap.StartTlsResponse)ctx_";
  protected final String TEXT_98 = ".extendedOperation(tldsReq_";
  protected final String TEXT_99 = ");" + NL + "  javax.net.ssl.SSLSession session_";
  protected final String TEXT_100 = " = tls_";
  protected final String TEXT_101 = ".negotiate((javax.net.ssl.SSLSocketFactory)talend.ssl.AdvancedSocketFactory.getDefault());" + NL + "  ";
  protected final String TEXT_102 = NL + "  ctx_";
  protected final String TEXT_103 = ".addToEnvironment(javax.naming.Context.SECURITY_AUTHENTICATION, \"simple\");" + NL + "  ctx_";
  protected final String TEXT_104 = ".addToEnvironment(javax.naming.Context.SECURITY_PRINCIPAL, ";
  protected final String TEXT_105 = ");" + NL + "  ctx_";
  protected final String TEXT_106 = ".addToEnvironment(javax.naming.Context.SECURITY_CREDENTIALS, decryptedPassword_";
  protected final String TEXT_107 = ");";
  protected final String TEXT_108 = NL;
  protected final String TEXT_109 = NL + "\tlog.info(\"";
  protected final String TEXT_110 = " - Connection to '\"+";
  protected final String TEXT_111 = " + \"' has succeeded.\");";
  protected final String TEXT_112 = NL + "\t\t\t\t\t";
  protected final String TEXT_113 = NL + "\t\t\t\t\tjavax.naming.ldap.InitialLdapContext ctx_";
  protected final String TEXT_114 = " = (javax.naming.ldap.InitialLdapContext)globalMap.get(\"";
  protected final String TEXT_115 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_116 = NL + "\t\t\t\t\t\tif(ctx_";
  protected final String TEXT_117 = "!=null) {" + NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_118 = " - Uses an existing connection ,connection URL is: '\" + ctx_";
  protected final String TEXT_119 = ".getEnvironment().get(javax.naming.Context.PROVIDER_URL) + \"'.\"); " + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_120 = NL + "\t\t\t\t\tbaseDN_";
  protected final String TEXT_121 = " = (String)globalMap.get(\"";
  protected final String TEXT_122 = "\");";
  protected final String TEXT_123 = NL + "\t\t\t\tint ";
  protected final String TEXT_124 = "_NB_LINE = 0;" + NL + "\t\t\t\tjavax.naming.directory.SearchControls searchCtls_";
  protected final String TEXT_125 = " = new javax.naming.directory.SearchControls();" + NL + "\t\t\t\tsearchCtls_";
  protected final String TEXT_126 = ".setSearchScope(javax.naming.directory.SearchControls.SUBTREE_SCOPE);" + NL + "\t\t\t\tsearchCtls_";
  protected final String TEXT_127 = ".setTimeLimit(";
  protected final String TEXT_128 = "*1000);" + NL + "\t\t\t\tsearchCtls_";
  protected final String TEXT_129 = ".setCountLimit(";
  protected final String TEXT_130 = ");";
  protected final String TEXT_131 = NL + "\t\t\t\t\t\t//get basce dn" + NL + "\t\t\t\t\t\tjavax.naming.directory.Attributes attrsNaming_";
  protected final String TEXT_132 = " = ctx_";
  protected final String TEXT_133 = ".getAttributes(\"\",new String[] {\"namingContexts\"});" + NL + "\t\t\t\t\t\tjavax.naming.directory.Attribute aNaming_";
  protected final String TEXT_134 = " = attrsNaming_";
  protected final String TEXT_135 = ".get(\"namingContexts\");" + NL + "\t\t\t\t\t\tif(aNaming_";
  protected final String TEXT_136 = " == null)" + NL + "\t\t\t\t\t\t{" + NL + "\t\t\t\t\t\t\taNaming_";
  protected final String TEXT_137 = " =attrsNaming_";
  protected final String TEXT_138 = ".get(\"namingcontexts\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t// String searchBase_";
  protected final String TEXT_139 = " = (aNaming_";
  protected final String TEXT_140 = "==null)|())?\"\":aNaming_";
  protected final String TEXT_141 = ".get().toString();\t\t " + NL + "\t\t\t\t\t\tString searchBase_";
  protected final String TEXT_142 = " = ((aNaming_";
  protected final String TEXT_143 = " == null) || ((aNaming_";
  protected final String TEXT_144 = " != null)" + NL + "\t\t\t\t\t\t\t\t\t\t&& (aNaming_";
  protected final String TEXT_145 = ".get().toString() != null)" + NL + "\t\t\t\t\t\t\t\t\t\t&& (aNaming_";
  protected final String TEXT_146 = ".get().toString().length() > 0) && (Character" + NL + "\t\t\t\t\t\t\t\t\t\t.isIdentifierIgnorable(aNaming_";
  protected final String TEXT_147 = ".get().toString().charAt(0))))) ? \"\"" + NL + "\t\t\t\t\t\t\t\t\t\t: aNaming_";
  protected final String TEXT_148 = ".get().toString();";
  protected final String TEXT_149 = NL + "\t\t\t\t\t\tString searchBase_";
  protected final String TEXT_150 = " = ";
  protected final String TEXT_151 = ";";
  protected final String TEXT_152 = NL + "\t\t\t\t\tString searchBase_";
  protected final String TEXT_153 = " = \"\";";
  protected final String TEXT_154 = NL + "\t\t\t\tbaseDN_";
  protected final String TEXT_155 = " = searchBase_";
  protected final String TEXT_156 = ";" + NL + "\t\t\t\tjavax.naming.directory.DirContext rootSchema_";
  protected final String TEXT_157 = " = null;" + NL + "\t\t\t\t";
  protected final String TEXT_158 = NL + "\t\t\t\t\t// Set the page size and initialize the cookie that we pass back in subsequent pages" + NL + "\t\t\t\t\tint pageSize_";
  protected final String TEXT_159 = " = ";
  protected final String TEXT_160 = ";" + NL + "\t\t\t\t\tbyte[] cookie_";
  protected final String TEXT_161 = " = null;" + NL + "\t\t\t\t\t// Request the paged results control" + NL + "\t\t\t\t\tjavax.naming.ldap.Control[] ctls_";
  protected final String TEXT_162 = " = new javax.naming.ldap.Control[] { new javax.naming.ldap.PagedResultsControl(pageSize_";
  protected final String TEXT_163 = ", true) };" + NL + "\t\t\t\t\tctx_";
  protected final String TEXT_164 = ".setRequestControls(ctls_";
  protected final String TEXT_165 = ");" + NL + "\t" + NL + "\t\t\t\t\tdo {" + NL + "\t\t\t\t";
  protected final String TEXT_166 = NL + NL + "\t\t\t\t\t\tjavax.naming.NamingEnumeration answer_";
  protected final String TEXT_167 = " = ctx_";
  protected final String TEXT_168 = ".search(searchBase_";
  protected final String TEXT_169 = ", ";
  protected final String TEXT_170 = ", searchCtls_";
  protected final String TEXT_171 = ");" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\trootSchema_";
  protected final String TEXT_172 = " = ctx_";
  protected final String TEXT_173 = ".getSchema(\"\");" + NL + "\t\t\t\t\t\tjava.util.Set<String> objectClasses_";
  protected final String TEXT_174 = " = new java.util.HashSet<String>();" + NL + "\t\t\t\t\t\tjava.util.Set<String> objectAttributes_";
  protected final String TEXT_175 = " = new java.util.HashSet<String>();" + NL + "\t\t\t\t\t\tjava.util.Set<String> mandatoryAttributes_";
  protected final String TEXT_176 = " = new java.util.HashSet<String>();" + NL + "\t\t\t\t\t\tjava.util.Set<String> optionalAttributes_";
  protected final String TEXT_177 = " = new java.util.HashSet<String>();" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_178 = NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_179 = " - Retrieving records from the service.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_180 = NL + "\t\t\t\t\twhile (answer_";
  protected final String TEXT_181 = " .hasMoreElements()) {//a" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_182 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_183 = " = null;\t\t\t";
  protected final String TEXT_184 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_185 = "_NB_LINE++;" + NL + "\t\t\t\t\t\tjavax.naming.directory.Attributes attrs_";
  protected final String TEXT_186 = " = null;";
  protected final String TEXT_187 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_188 = " = new ";
  protected final String TEXT_189 = "Struct();" + NL + "\t\t\t\t\t\t\ttry{";
  protected final String TEXT_190 = NL + "\t\t\t\t\t\t\t\tjavax.naming.directory.SearchResult sr_";
  protected final String TEXT_191 = "  = (javax.naming.directory.SearchResult) answer_";
  protected final String TEXT_192 = ".next();" + NL + "\t\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_193 = "_RESULT_NAME\",sr_";
  protected final String TEXT_194 = ".getName());" + NL + "\t\t\t\t\t\t\t\tattrs_";
  protected final String TEXT_195 = " = sr_";
  protected final String TEXT_196 = ".getAttributes();" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tobjectClasses_";
  protected final String TEXT_197 = ".clear();" + NL + "\t\t\t\t\t\t\t\tobjectAttributes_";
  protected final String TEXT_198 = ".clear();" + NL + "\t\t\t\t\t\t\t\tmandatoryAttributes_";
  protected final String TEXT_199 = ".clear();" + NL + "\t\t\t\t\t\t\t\toptionalAttributes_";
  protected final String TEXT_200 = ".clear();" + NL + "" + NL + "\t\t\t\t\t\t\t\tfor (javax.naming.NamingEnumeration e_";
  protected final String TEXT_201 = " = attrs_";
  protected final String TEXT_202 = ".getIDs(); e_";
  protected final String TEXT_203 = ".hasMore();){" + NL + "\t\t\t\t\t\t\t\t\tobjectAttributes_";
  protected final String TEXT_204 = ".add((String)e_";
  protected final String TEXT_205 = ".next());\t" + NL + "\t\t\t\t\t   \t\t\t}" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tfor (javax.naming.NamingEnumeration e_";
  protected final String TEXT_206 = " = attrs_";
  protected final String TEXT_207 = ".get(\"objectClass\").getAll(); e_";
  protected final String TEXT_208 = ".hasMore();){" + NL + "\t\t\t\t\t\t\t\t\tobjectClasses_";
  protected final String TEXT_209 = ".add((String)e_";
  protected final String TEXT_210 = ".next());" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tfor(String objectClass_";
  protected final String TEXT_211 = " : objectClasses_";
  protected final String TEXT_212 = ") {" + NL + "\t\t\t\t\t\t\t\t\tjavax.naming.directory.DirContext schema_";
  protected final String TEXT_213 = " = (javax.naming.directory.DirContext) rootSchema_";
  protected final String TEXT_214 = ".lookup(";
  protected final String TEXT_215 = " + objectClass_";
  protected final String TEXT_216 = ");" + NL + "\t\t\t\t\t\t\t\t\tjavax.naming.directory.Attributes attributes_";
  protected final String TEXT_217 = " = schema_";
  protected final String TEXT_218 = ".getAttributes(\"\");" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\tif(attributes_";
  protected final String TEXT_219 = " != null) {" + NL + "\t\t\t\t\t\t\t\t\t\tif (attributes_";
  protected final String TEXT_220 = ".get(\"must\") != null) {" + NL + "\t\t\t\t\t\t\t\t\t\t\tfor (javax.naming.NamingEnumeration e_";
  protected final String TEXT_221 = " = attributes_";
  protected final String TEXT_222 = ".get(\"must\").getAll(); e_";
  protected final String TEXT_223 = ".hasMore();){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tmandatoryAttributes_";
  protected final String TEXT_224 = ".add((String)e_";
  protected final String TEXT_225 = ".next());" + NL + "\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\tif (attributes_";
  protected final String TEXT_226 = ".get(\"may\") != null) {" + NL + "\t\t\t\t\t\t\t\t\t\t\tfor (javax.naming.NamingEnumeration e_";
  protected final String TEXT_227 = " = attributes_";
  protected final String TEXT_228 = ".get(\"may\").getAll(); e_";
  protected final String TEXT_229 = ".hasMore();){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\toptionalAttributes_";
  protected final String TEXT_230 = ".add((String)e_";
  protected final String TEXT_231 = ".next());" + NL + "\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\tschema_";
  protected final String TEXT_232 = ".close();" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t \t\t// for output" + NL + "\t\t\t\t\t\t \t\tStringBuilder attrStr_";
  protected final String TEXT_233 = " = null;";
  protected final String TEXT_234 = "\t\t  " + NL + "\t\t\t\t\t\t\t\t\t\t\tif (attrs_";
  protected final String TEXT_235 = " != null) {//b";
  protected final String TEXT_236 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tattrStr_";
  protected final String TEXT_237 = " = new StringBuilder();" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tfor (String objectAttribute_";
  protected final String TEXT_238 = " : objectAttributes_";
  protected final String TEXT_239 = "){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tif(attrStr_";
  protected final String TEXT_240 = ".length()>0){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tattrStr_";
  protected final String TEXT_241 = ".append(";
  protected final String TEXT_242 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tattrStr_";
  protected final String TEXT_243 = ".append(objectAttribute_";
  protected final String TEXT_244 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_245 = ".";
  protected final String TEXT_246 = " = attrStr_";
  protected final String TEXT_247 = ".toString();";
  protected final String TEXT_248 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tattrStr_";
  protected final String TEXT_249 = " = new StringBuilder();" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tfor (String mandatoryAttribute_";
  protected final String TEXT_250 = " : mandatoryAttributes_";
  protected final String TEXT_251 = "){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tif(attrStr_";
  protected final String TEXT_252 = ".length()>0){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tattrStr_";
  protected final String TEXT_253 = ".append(";
  protected final String TEXT_254 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tattrStr_";
  protected final String TEXT_255 = ".append(mandatoryAttribute_";
  protected final String TEXT_256 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_257 = ".";
  protected final String TEXT_258 = " = attrStr_";
  protected final String TEXT_259 = ".toString();";
  protected final String TEXT_260 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tattrStr_";
  protected final String TEXT_261 = " = new StringBuilder();" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tfor (String optionalAttribute_";
  protected final String TEXT_262 = " : optionalAttributes_";
  protected final String TEXT_263 = "){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tif(attrStr_";
  protected final String TEXT_264 = ".length()>0){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tattrStr_";
  protected final String TEXT_265 = ".append(";
  protected final String TEXT_266 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tattrStr_";
  protected final String TEXT_267 = ".append(optionalAttribute_";
  protected final String TEXT_268 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_269 = ".";
  protected final String TEXT_270 = " = attrStr_";
  protected final String TEXT_271 = ".toString();";
  protected final String TEXT_272 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tjavax.naming.directory.Attribute attr_";
  protected final String TEXT_273 = "_";
  protected final String TEXT_274 = " = attrs_";
  protected final String TEXT_275 = ".get(\"";
  protected final String TEXT_276 = "\");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tif(attr_";
  protected final String TEXT_277 = "_";
  protected final String TEXT_278 = " != null)" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t{" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tattrStr_";
  protected final String TEXT_279 = " = new StringBuilder();" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfor (javax.naming.NamingEnumeration e_";
  protected final String TEXT_280 = " = attr_";
  protected final String TEXT_281 = "_";
  protected final String TEXT_282 = ".getAll(); e_";
  protected final String TEXT_283 = ".hasMore();){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tif(attrStr_";
  protected final String TEXT_284 = ".length()>0){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tattrStr_";
  protected final String TEXT_285 = ".append(";
  protected final String TEXT_286 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tattrStr_";
  protected final String TEXT_287 = ".append(e_";
  protected final String TEXT_288 = ".next().toString());" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_289 = ".";
  protected final String TEXT_290 = " = attrStr_";
  protected final String TEXT_291 = ".toString();" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_292 = ".";
  protected final String TEXT_293 = " = null;" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\t\t\t";
  protected final String TEXT_294 = NL + "\t\t\t\t\t\t\t\t\t\t\t}//b" + NL + "\t\t\t\t\t\t\t} catch (java.lang.Exception e) {" + NL;
  protected final String TEXT_295 = NL + "\t\t\t\t\t\t\t\t\tthrow(e);";
  protected final String TEXT_296 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_297 = " = new ";
  protected final String TEXT_298 = "Struct();";
  protected final String TEXT_299 = NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_300 = ".";
  protected final String TEXT_301 = " = ";
  protected final String TEXT_302 = ".";
  protected final String TEXT_303 = ";";
  protected final String TEXT_304 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_305 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_306 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_307 = " = null;";
  protected final String TEXT_308 = NL + "\t\t\t\t\t\t\t\t\t\tSystem.err.println(e.getMessage());";
  protected final String TEXT_309 = NL + "\t\t\t\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_310 = " - \" + e.getMessage());";
  protected final String TEXT_311 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_312 = " = null;";
  protected final String TEXT_313 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_314 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_315 = ";";
  protected final String TEXT_316 = NL + "\t\t\t\t\t\t\t}";
  protected final String TEXT_317 = NL + "///////////////////////////////////\t\t";
  protected final String TEXT_318 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_19);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_29);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	List<IMetadataTable> metadatas = node.getMetadataList();
		if ((metadatas!=null)&&(metadatas.size()>0)) {
			IMetadataTable metadata = metadatas.get(0);			
			if(metadata!=null) {

				List<IMetadataColumn> columnList = metadata.getListColumns();
				String cid = node.getUniqueName();
				String limit =ElementParameterParser.getValue(node, "__LIMIT__");
				boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));	
				boolean paging =("true").equals(ElementParameterParser.getValue(node, "__ISPAGING__"));	
				String pageSize = ElementParameterParser.getValue(node, "__PAGESIZE__");
				String classDefRoot = ElementParameterParser.getValue(node, "__CLASSDEF_ROOT__");
				String filter=ElementParameterParser.getValue(node, "__FILTER__");
				String separator=ElementParameterParser.getValue(node, "__MULTI_VALUE_SEPARATOR__");
				String timeout =ElementParameterParser.getValue(node, "__TIMEOUT__");
				String baseDN=ElementParameterParser.getValue(node, "__BASEDN__");
			
				String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
				String exConn= "conn_" + connection;
				String exConnBaseDN = "connBaseDN_" + connection;
				String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
				boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
				if(("false").equals(useExistingConn)){
					boolean useAuth = "true".equals(ElementParameterParser.getValue(node, "__AUTHENTIFICATION__"));
					String user =ElementParameterParser.getValue(node, "__USER__");

					String host=ElementParameterParser.getValue(node, "__HOST__");
					String port=ElementParameterParser.getValue(node, "__PORT__");
					String protocol=ElementParameterParser.getValue(node, "__PROTOCOL__");
					String advanced=ElementParameterParser.getValue(node, "__ADVANCEDCA__");
					String storepath=ElementParameterParser.getValue(node, "__STORECA__");
					String storepwd = ElementParameterParser.getValue(node, "__STORECAPWD__");
					boolean alwaysTrust = ("true").equals(ElementParameterParser.getValue(node, "__ALWAYS_TRUST__"));
					String referrals=ElementParameterParser.getValue(node, "__REFERRALS__");
					String aliases=ElementParameterParser.getValue(node, "__ALIASES__");

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(referrals);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(aliases);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_41);
    
					if(("LDAPS").equals(protocol)){

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
					}
					if(("LDAPS").equals(protocol) || ("TLS").equals(protocol)){
						if(("true").equals(advanced)){
							if(alwaysTrust) {

    stringBuffer.append(TEXT_45);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    
							} else {

    stringBuffer.append(TEXT_49);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(storepath );
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_53);
    stringBuffer.append(storepath);
    stringBuffer.append(TEXT_54);
    
								if(storepwd !=null && storepwd.length() !=0 ){

    stringBuffer.append(TEXT_55);
    
                                    String passwordFieldName = "__STORECAPWD__";
                                    
    stringBuffer.append(TEXT_56);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_59);
    } else {
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
								}
							}
						}
					}

    stringBuffer.append(TEXT_65);
    stringBuffer.append(TEXT_66);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_69);
    }
    stringBuffer.append(TEXT_70);
    if(useAuth){
    stringBuffer.append(TEXT_71);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    }
    stringBuffer.append(TEXT_74);
    
  String passwordFieldName = "__PASS__";
  
    stringBuffer.append(TEXT_75);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_78);
    } else {
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_81);
    }
    }
    stringBuffer.append(TEXT_82);
    
	//the authentication is being performed after establishment of the TLS session
	if(!"TLS".equals(protocol)){
		//we only keep the logic like before now, we may need to move it in the "useAuth" block.

    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    
		if(useAuth){

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
		}
	}

    stringBuffer.append(TEXT_90);
    if(!cid.contains("tLDAPInput")){
    stringBuffer.append(TEXT_91);
    }
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
if("TLS".equals(protocol)){

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    if(useAuth){
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    }
    
}

    stringBuffer.append(TEXT_108);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_111);
    }
    stringBuffer.append(TEXT_112);
    
				}else{

    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(exConn);
    stringBuffer.append(TEXT_115);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    }
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(exConnBaseDN);
    stringBuffer.append(TEXT_122);
    
				}

    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(limit );
    stringBuffer.append(TEXT_130);
    
				if(("false").equals(useExistingConn)){
					if(baseDN == null || baseDN.length()<=2){

    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    
					}else{

    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(baseDN);
    stringBuffer.append(TEXT_151);
    
					}
				}else{

    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
				}

    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    if(paging){
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(pageSize );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    }
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(filter);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    }
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    
						List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
					
						String rejectConnName = "";
						List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
						if(rejectConns != null && rejectConns.size() > 0) {
							IConnection rejectConn = rejectConns.get(0);
							rejectConnName = rejectConn.getName();
						}
						List<IMetadataColumn> rejectColumnList = null;
						IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
						if(metadataTable != null) {
							rejectColumnList = metadataTable.getListColumns();	  
						}
						
						String firstConnName = "";
						if (conns!=null) {
							if (conns.size()>0) {
								for (int i=0;i<conns.size();i++) {
									IConnection connTemp = conns.get(i);
									if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
										if(i==0){
											firstConnName = connTemp.getName();
										}

    stringBuffer.append(TEXT_182);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_183);
    
									}
								}
							}
						}

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    
						if(firstConnName.length()>0){

    stringBuffer.append(TEXT_187);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_189);
    
						}

    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(classDefRoot );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    
								if (conns!=null) {//1
									if (conns.size()>0) {//2
										IConnection conn = conns.get(0); //the first connection
										if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//3
											firstConnName = conn.getName();		 
						
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    
												for(IMetadataColumn column:columnList){//5
													if ("objectAttributes".equals(column.getLabel())) {
														// Availible attributes for this object

    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    
													} else if ("mandatoryAttributes".equals(column.getLabel())) {

    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    
													} else if ("optionalAttributes".equals(column.getLabel())) {

    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    
													} else {

    stringBuffer.append(TEXT_272);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_276);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_289);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_293);
    					
													}
												}//5

    stringBuffer.append(TEXT_294);
    
								if (dieOnError) {

    stringBuffer.append(TEXT_295);
    
								} else {
									if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_296);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_298);
    
										for(IMetadataColumn column : metadata.getListColumns()) {

    stringBuffer.append(TEXT_299);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_301);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_303);
    
										}

    stringBuffer.append(TEXT_304);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_306);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_307);
    
									} else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_308);
    
										if(isLog4jEnabled){

    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    
										}

    stringBuffer.append(TEXT_311);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_312);
    
									} else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_313);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_315);
    
									}
								}

    stringBuffer.append(TEXT_316);
    
										}//3
									}//2
								}//1

    stringBuffer.append(TEXT_317);
    
			}
		}

    stringBuffer.append(TEXT_318);
    return stringBuffer.toString();
  }
}
