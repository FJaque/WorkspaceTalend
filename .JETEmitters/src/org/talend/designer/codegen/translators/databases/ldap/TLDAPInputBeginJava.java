package org.talend.designer.codegen.translators.databases.ldap;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import java.util.List;
import java.util.Map;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.utils.NodeUtil;

public class TLDAPInputBeginJava
{
  protected static String nl;
  public static synchronized TLDAPInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLDAPInputBeginJava result = new TLDAPInputBeginJava();
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
  protected final String TEXT_30 = NL + "String baseDN_";
  protected final String TEXT_31 = " = \"\";" + NL + "\tint ";
  protected final String TEXT_32 = "_NB_LINE = 0;";
  protected final String TEXT_33 = NL + "\tjava.util.Hashtable env_";
  protected final String TEXT_34 = " = new java.util.Hashtable();" + NL + "\tenv_";
  protected final String TEXT_35 = ".put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, \"com.sun.jndi.ldap.LdapCtxFactory\");" + NL + "\tenv_";
  protected final String TEXT_36 = ".put(javax.naming.Context.REFERRAL, \"";
  protected final String TEXT_37 = "\");" + NL + "\tenv_";
  protected final String TEXT_38 = ".put(\"java.naming.ldap.derefAliases\",\"";
  protected final String TEXT_39 = "\");";
  protected final String TEXT_40 = NL + "\tenv_";
  protected final String TEXT_41 = ".put(javax.naming.Context.PROVIDER_URL, \"ldap://\"+";
  protected final String TEXT_42 = "+\":\"+";
  protected final String TEXT_43 = ");";
  protected final String TEXT_44 = NL + "\tenv_";
  protected final String TEXT_45 = ".put(javax.naming.Context.PROVIDER_URL, \"ldap://\"+";
  protected final String TEXT_46 = "+\":\"+";
  protected final String TEXT_47 = ");";
  protected final String TEXT_48 = NL + "\tenv_";
  protected final String TEXT_49 = ".put(javax.naming.Context.SECURITY_PROTOCOL, \"ssl\");" + NL + "\tenv_";
  protected final String TEXT_50 = ".put(\"java.naming.ldap.factory.socket\", \"talend.ssl.AdvancedSocketFactory\");";
  protected final String TEXT_51 = NL + "\t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_53 = " - Adnanced CA trusting all certs.\");" + NL + "\t\t\t\t";
  protected final String TEXT_54 = NL + "\t\t\t\ttalend.ssl.AdvancedSocketFactory.alwaysTrust();";
  protected final String TEXT_55 = NL + "\t\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_57 = " - Advanced CA using a store CA file and Keystore password.\");" + NL + "\t\t\t\t\tlog.debug(\"Store CA : '\" + ";
  protected final String TEXT_58 = " + \"'.\");" + NL + "\t\t\t\t";
  protected final String TEXT_59 = NL + "\t\t\t\ttalend.ssl.AdvancedSocketFactory.setCertStorePath(";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = NL + "\t\t\t\t";
  protected final String TEXT_62 = NL + "            ";
  protected final String TEXT_63 = " " + NL + "                    \tfinal String decryptedPwd_";
  protected final String TEXT_64 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_65 = ");";
  protected final String TEXT_66 = NL + "                    \tfinal String decryptedPwd_";
  protected final String TEXT_67 = " = ";
  protected final String TEXT_68 = "; ";
  protected final String TEXT_69 = "\t\t\t\t" + NL + "\t\t\t\t" + NL + "\t\t\t\t\ttalend.ssl.AdvancedSocketFactory.setCertStorePassword(decryptedPwd_";
  protected final String TEXT_70 = ");";
  protected final String TEXT_71 = NL + "   " + NL + "   \tjavax.naming.ldap.InitialLdapContext ctx_";
  protected final String TEXT_72 = " = null;" + NL + "\ttry{" + NL + "\t\t";
  protected final String TEXT_73 = NL;
  protected final String TEXT_74 = NL + "\tlog.info(\"";
  protected final String TEXT_75 = " - Connection attempt to '\"+ ";
  protected final String TEXT_76 = " + \"'.\");";
  protected final String TEXT_77 = NL;
  protected final String TEXT_78 = NL + "\t";
  protected final String TEXT_79 = NL + "\tlog.info(\"";
  protected final String TEXT_80 = " - Authentication using username and password.\");" + NL + "\t";
  protected final String TEXT_81 = NL + "\t" + NL + "\t";
  protected final String TEXT_82 = NL + "  ";
  protected final String TEXT_83 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_84 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_85 = ");";
  protected final String TEXT_86 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_87 = " = ";
  protected final String TEXT_88 = "; ";
  protected final String TEXT_89 = NL;
  protected final String TEXT_90 = NL + "\t\tenv_";
  protected final String TEXT_91 = ".put(javax.naming.Context.SECURITY_AUTHENTICATION, \"simple\");// \"none\",\"simple\",\"strong\"";
  protected final String TEXT_92 = NL + "    env_";
  protected final String TEXT_93 = ".put(javax.naming.Context.SECURITY_PRINCIPAL, ";
  protected final String TEXT_94 = ");" + NL + "    env_";
  protected final String TEXT_95 = ".put(javax.naming.Context.SECURITY_CREDENTIALS, decryptedPassword_";
  protected final String TEXT_96 = ");";
  protected final String TEXT_97 = NL;
  protected final String TEXT_98 = "javax.naming.ldap.InitialLdapContext";
  protected final String TEXT_99 = " ctx_";
  protected final String TEXT_100 = " = new javax.naming.ldap.InitialLdapContext(env_";
  protected final String TEXT_101 = ", null);" + NL;
  protected final String TEXT_102 = NL + "\tjavax.naming.ldap.StartTlsRequest tldsReq_";
  protected final String TEXT_103 = " = new javax.naming.ldap.StartTlsRequest();" + NL + "  javax.naming.ldap.StartTlsResponse tls_";
  protected final String TEXT_104 = " =(javax.naming.ldap.StartTlsResponse)ctx_";
  protected final String TEXT_105 = ".extendedOperation(tldsReq_";
  protected final String TEXT_106 = ");" + NL + "  javax.net.ssl.SSLSession session_";
  protected final String TEXT_107 = " = tls_";
  protected final String TEXT_108 = ".negotiate((javax.net.ssl.SSLSocketFactory)talend.ssl.AdvancedSocketFactory.getDefault());" + NL + "  ";
  protected final String TEXT_109 = NL + "  ctx_";
  protected final String TEXT_110 = ".addToEnvironment(javax.naming.Context.SECURITY_AUTHENTICATION, \"simple\");" + NL + "  ctx_";
  protected final String TEXT_111 = ".addToEnvironment(javax.naming.Context.SECURITY_PRINCIPAL, ";
  protected final String TEXT_112 = ");" + NL + "  ctx_";
  protected final String TEXT_113 = ".addToEnvironment(javax.naming.Context.SECURITY_CREDENTIALS, decryptedPassword_";
  protected final String TEXT_114 = ");";
  protected final String TEXT_115 = NL;
  protected final String TEXT_116 = NL + "\tlog.info(\"";
  protected final String TEXT_117 = " - Connection to '\"+";
  protected final String TEXT_118 = " + \"' has succeeded.\");";
  protected final String TEXT_119 = NL + "\ttry{" + NL + "\tjavax.naming.ldap.InitialLdapContext ctx_";
  protected final String TEXT_120 = " = (javax.naming.ldap.InitialLdapContext)globalMap.get(\"";
  protected final String TEXT_121 = "\");" + NL + "\t";
  protected final String TEXT_122 = NL + "\t\tif(ctx_";
  protected final String TEXT_123 = "!=null) {" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_124 = " - Uses an existing connection ,connection URL is: '\" + ctx_";
  protected final String TEXT_125 = ".getEnvironment().get(javax.naming.Context.PROVIDER_URL) + \"'.\"); " + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_126 = NL + "\tbaseDN_";
  protected final String TEXT_127 = " = (String)globalMap.get(\"";
  protected final String TEXT_128 = "\");";
  protected final String TEXT_129 = NL + "\t" + NL + "\tjavax.naming.directory.SearchControls searchCtls_";
  protected final String TEXT_130 = " = new javax.naming.directory.SearchControls();" + NL + "    searchCtls_";
  protected final String TEXT_131 = ".setSearchScope(javax.naming.directory.SearchControls.SUBTREE_SCOPE);";
  protected final String TEXT_132 = NL + "        routines.system.Dynamic dcg_";
  protected final String TEXT_133 = " =  new routines.system.Dynamic();";
  protected final String TEXT_134 = NL + "    searchCtls_";
  protected final String TEXT_135 = ".setReturningAttributes(new String[]{";
  protected final String TEXT_136 = NL + "\t\t\"";
  protected final String TEXT_137 = "\",";
  protected final String TEXT_138 = "    " + NL + "    });";
  protected final String TEXT_139 = NL + "    searchCtls_";
  protected final String TEXT_140 = ".setTimeLimit(";
  protected final String TEXT_141 = "*1000);" + NL + "    searchCtls_";
  protected final String TEXT_142 = ".setCountLimit(";
  protected final String TEXT_143 = ");";
  protected final String TEXT_144 = NL + "\t//get basce dn" + NL + "\tjavax.naming.directory.Attributes attrsNaming_";
  protected final String TEXT_145 = " = ctx_";
  protected final String TEXT_146 = ".getAttributes(\"\",new String[] {\"namingContexts\"});" + NL + "    javax.naming.directory.Attribute aNaming_";
  protected final String TEXT_147 = " = attrsNaming_";
  protected final String TEXT_148 = ".get(\"namingContexts\");" + NL + "    if(aNaming_";
  protected final String TEXT_149 = " == null)" + NL + "    {" + NL + "        aNaming_";
  protected final String TEXT_150 = " =attrsNaming_";
  protected final String TEXT_151 = ".get(\"namingcontexts\");" + NL + "    }" + NL + "\t\tbaseDN_";
  protected final String TEXT_152 = " = ((aNaming_";
  protected final String TEXT_153 = " == null) || ((aNaming_";
  protected final String TEXT_154 = " != null)" + NL + "                    && (aNaming_";
  protected final String TEXT_155 = ".get().toString() != null)" + NL + "                    && (aNaming_";
  protected final String TEXT_156 = ".get().toString().length() > 0) && (Character" + NL + "                    .isIdentifierIgnorable(aNaming_";
  protected final String TEXT_157 = ".get().toString().charAt(0))))) ? \"\"" + NL + "                    : aNaming_";
  protected final String TEXT_158 = ".get().toString();";
  protected final String TEXT_159 = NL + "\t\tbaseDN_";
  protected final String TEXT_160 = " = ";
  protected final String TEXT_161 = ";";
  protected final String TEXT_162 = NL + "\t\tString binaryColumns_";
  protected final String TEXT_163 = " = \"";
  protected final String TEXT_164 = "\";";
  protected final String TEXT_165 = NL + "\t\tString[] columnsInSchema_";
  protected final String TEXT_166 = " = \"";
  protected final String TEXT_167 = "\".split(\",\");" + NL + "\t\tjava.util.Arrays.sort(columnsInSchema_";
  protected final String TEXT_168 = ");" + NL + "    \tjavax.naming.directory.Attributes attrsDyn_";
  protected final String TEXT_169 = " = null;" + NL + "    \tjavax.naming.NamingEnumeration answerDyn_";
  protected final String TEXT_170 = " = ctx_";
  protected final String TEXT_171 = ".search(";
  protected final String TEXT_172 = "baseDN_";
  protected final String TEXT_173 = "\"\"";
  protected final String TEXT_174 = ", ";
  protected final String TEXT_175 = ", searchCtls_";
  protected final String TEXT_176 = ");" + NL + "\t\t";
  protected final String TEXT_177 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_178 = " - Retrieving records from the service.\");" + NL + "\t\t";
  protected final String TEXT_179 = NL + "    \twhile (answerDyn_";
  protected final String TEXT_180 = " .hasMoreElements()) {" + NL + "    \t\tjavax.naming.directory.SearchResult srDyn_";
  protected final String TEXT_181 = "  = (javax.naming.directory.SearchResult) answerDyn_";
  protected final String TEXT_182 = ".next();" + NL + "            attrsDyn_";
  protected final String TEXT_183 = " = srDyn_";
  protected final String TEXT_184 = ".getAttributes();" + NL + "            javax.naming.NamingEnumeration ne_";
  protected final String TEXT_185 = " =attrsDyn_";
  protected final String TEXT_186 = ".getAll();" + NL + "\t\t\twhile(ne_";
  protected final String TEXT_187 = ".hasMoreElements()){" + NL + "\t\t\t\tString element_";
  protected final String TEXT_188 = " = ne_";
  protected final String TEXT_189 = ".nextElement().toString();" + NL + "\t\t\t\tint splitorIndex_";
  protected final String TEXT_190 = " = element_";
  protected final String TEXT_191 = ".indexOf(\":\");" + NL + "\t\t\t\tif(splitorIndex_";
  protected final String TEXT_192 = ">0){" + NL + "\t\t\t\t\tString columnName_";
  protected final String TEXT_193 = " = element_";
  protected final String TEXT_194 = ".substring(0,splitorIndex_";
  protected final String TEXT_195 = ");" + NL + "\t\t\t\t\tif(java.util.Arrays.binarySearch(columnsInSchema_";
  protected final String TEXT_196 = ",columnName_";
  protected final String TEXT_197 = ") < 0 || \"";
  protected final String TEXT_198 = "\".equals(columnName_";
  protected final String TEXT_199 = ")){" + NL + "\t\t\t\t\t\tDynamicMetadata dm_";
  protected final String TEXT_200 = " = new DynamicMetadata();" + NL + "\t\t\t\t\t\tdm_";
  protected final String TEXT_201 = ".setName(columnName_";
  protected final String TEXT_202 = ");" + NL + "\t\t\t\t\t\tdm_";
  protected final String TEXT_203 = ".setDbName(columnName_";
  protected final String TEXT_204 = ");" + NL + "\t\t\t\t\t\tdm_";
  protected final String TEXT_205 = ".setType(\"id_String\");" + NL + "\t\t\t\t\t\tif(!dcg_";
  protected final String TEXT_206 = ".metadatas.contains(dm_";
  protected final String TEXT_207 = ")){" + NL + "\t\t\t\t\t\t\tdcg_";
  protected final String TEXT_208 = ".metadatas.add(dm_";
  protected final String TEXT_209 = ");";
  protected final String TEXT_210 = NL + "\t\t\t\t\t\t\t\t\tif(binaryColumns_";
  protected final String TEXT_211 = ".length()>0){" + NL + "\t\t\t\t\t\t\t\t\t\tbinaryColumns_";
  protected final String TEXT_212 = "+=\" \";" + NL + "\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_213 = NL + "\t\t\t\t\t\t\t\t\tbinaryColumns_";
  protected final String TEXT_214 = "+=\" \";";
  protected final String TEXT_215 = NL + "\t\t\t\t\t\t\t\tbinaryColumns_";
  protected final String TEXT_216 = "+=columnName_";
  protected final String TEXT_217 = ";";
  protected final String TEXT_218 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "    \t}";
  protected final String TEXT_219 = NL + "    // Set the page size and initialize the cookie that we pass back in subsequent pages" + NL + "    int pageSize_";
  protected final String TEXT_220 = " = ";
  protected final String TEXT_221 = ";" + NL + "    byte[] cookie_";
  protected final String TEXT_222 = " = null;" + NL + "    // Request the paged results control" + NL + "    javax.naming.ldap.Control[] ctls_";
  protected final String TEXT_223 = " = new javax.naming.ldap.Control[] { new javax.naming.ldap.PagedResultsControl(pageSize_";
  protected final String TEXT_224 = ", true) };" + NL + "    ctx_";
  protected final String TEXT_225 = ".setRequestControls(ctls_";
  protected final String TEXT_226 = ");" + NL + "    " + NL + "do {";
  protected final String TEXT_227 = NL + "\t\tif(binaryColumns_";
  protected final String TEXT_228 = ".length()>0){" + NL + "\t\t\tjava.util.Hashtable orignal_env_";
  protected final String TEXT_229 = "= ctx_";
  protected final String TEXT_230 = ".getEnvironment();" + NL + "\t\t\torignal_env_";
  protected final String TEXT_231 = ".put(\"java.naming.ldap.attributes.binary\",binaryColumns_";
  protected final String TEXT_232 = ");" + NL + "\t\t\tctx_";
  protected final String TEXT_233 = " = new javax.naming.ldap.InitialLdapContext(orignal_env_";
  protected final String TEXT_234 = ", null);" + NL + "\t\t}";
  protected final String TEXT_235 = NL + NL + "    javax.naming.NamingEnumeration answer_";
  protected final String TEXT_236 = " = ctx_";
  protected final String TEXT_237 = ".search(";
  protected final String TEXT_238 = "baseDN_";
  protected final String TEXT_239 = "\"\"";
  protected final String TEXT_240 = ", ";
  protected final String TEXT_241 = ", searchCtls_";
  protected final String TEXT_242 = ");" + NL + "\t";
  protected final String TEXT_243 = NL + "\t\tlog.info(\"";
  protected final String TEXT_244 = " - Retrieving records from the service.\");" + NL + "\t";
  protected final String TEXT_245 = NL + "    while (answer_";
  protected final String TEXT_246 = " .hasMoreElements()) {//a";
  protected final String TEXT_247 = NL + "    \t\t";
  protected final String TEXT_248 = " = null;\t\t\t";
  protected final String TEXT_249 = NL + "    \t";
  protected final String TEXT_250 = "_NB_LINE++;" + NL + "    \tjavax.naming.directory.Attributes attrs_";
  protected final String TEXT_251 = " = null;";
  protected final String TEXT_252 = NL + "\t\t";
  protected final String TEXT_253 = " = new ";
  protected final String TEXT_254 = "Struct(); " + NL + "\ttry{";
  protected final String TEXT_255 = NL + NL + "            javax.naming.directory.SearchResult sr_";
  protected final String TEXT_256 = "  = (javax.naming.directory.SearchResult) answer_";
  protected final String TEXT_257 = ".next();" + NL + "    \t\tglobalMap.put(\"";
  protected final String TEXT_258 = "_RESULT_NAME\",sr_";
  protected final String TEXT_259 = ".getName());" + NL + "            attrs_";
  protected final String TEXT_260 = " = sr_";
  protected final String TEXT_261 = ".getAttributes();" + NL + "     \t\t// for output";
  protected final String TEXT_262 = "          " + NL + "        if (attrs_";
  protected final String TEXT_263 = " != null) {//b";
  protected final String TEXT_264 = NL + "\t\t\t\t\t\t\tif(attrs_";
  protected final String TEXT_265 = ".get(\"";
  protected final String TEXT_266 = "\") !=null){" + NL + "                            \t";
  protected final String TEXT_267 = ".";
  protected final String TEXT_268 = " = (byte[])attrs_";
  protected final String TEXT_269 = ".get(\"";
  protected final String TEXT_270 = "\").get();" + NL + "    \t\t\t\t\t\t} else {" + NL + "                           \t\t";
  protected final String TEXT_271 = ".";
  protected final String TEXT_272 = " = null;" + NL + "    \t\t\t\t\t\t}";
  protected final String TEXT_273 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_274 = ".";
  protected final String TEXT_275 = " = (\"\".equals(sr_";
  protected final String TEXT_276 = ".getName())?sr_";
  protected final String TEXT_277 = ".getName():(sr_";
  protected final String TEXT_278 = ".getName()+ \",\")) + baseDN_";
  protected final String TEXT_279 = ";";
  protected final String TEXT_280 = NL + "\t\t\t\t\t\t\t\tdcg_";
  protected final String TEXT_281 = ".clearColumnValues();" + NL + "\t\t\t\t\t\t\t\tfor(DynamicMetadata dm_";
  protected final String TEXT_282 = " :dcg_";
  protected final String TEXT_283 = ".metadatas){" + NL + "\t\t\t\t\t\t\t\t\tjavax.naming.directory.Attribute attr_";
  protected final String TEXT_284 = "_";
  protected final String TEXT_285 = " = attrs_";
  protected final String TEXT_286 = ".get(dm_";
  protected final String TEXT_287 = ".getDbName());" + NL + "\t\t\t\t\t\t\t\t\tif(attr_";
  protected final String TEXT_288 = "_";
  protected final String TEXT_289 = " != null){" + NL + "\t\t\t\t\t\t\t\t\t\tStringBuilder attrStr_";
  protected final String TEXT_290 = " = new StringBuilder();" + NL + "\t\t\t\t\t\t    \t\t\tfor (javax.naming.NamingEnumeration e_";
  protected final String TEXT_291 = " = attr_";
  protected final String TEXT_292 = "_";
  protected final String TEXT_293 = ".getAll(); e_";
  protected final String TEXT_294 = ".hasMore();){" + NL + "\t\t\t\t\t\t    \t\t\t\tif(attrStr_";
  protected final String TEXT_295 = ".length()>0){" + NL + "\t\t\t\t\t\t    \t\t\t\t\tattrStr_";
  protected final String TEXT_296 = ".append(";
  protected final String TEXT_297 = ");" + NL + "\t\t\t\t\t\t    \t\t\t\t}" + NL + "\t\t\t\t\t\t    \t\t\t\tattrStr_";
  protected final String TEXT_298 = ".append(e_";
  protected final String TEXT_299 = ".next().toString());" + NL + "\t\t\t\t\t\t    \t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\tdcg_";
  protected final String TEXT_300 = ".addColumnValue(attrStr_";
  protected final String TEXT_301 = ".toString());" + NL + "\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\tdcg_";
  protected final String TEXT_302 = ".addColumnValue(null);" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_303 = ".";
  protected final String TEXT_304 = " = dcg_";
  protected final String TEXT_305 = ";";
  protected final String TEXT_306 = NL + "\t\t\t\t\t\t\t\tjavax.naming.directory.Attribute attr_";
  protected final String TEXT_307 = "_";
  protected final String TEXT_308 = " = attrs_";
  protected final String TEXT_309 = ".get(\"";
  protected final String TEXT_310 = "\");" + NL + "\t\t\t\t\t\t\t\tif(attr_";
  protected final String TEXT_311 = "_";
  protected final String TEXT_312 = " != null){";
  protected final String TEXT_313 = "\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\tList list_";
  protected final String TEXT_314 = " = new java.util.ArrayList();" + NL + "\t\t\t\t\t\t\t\t\t\tfor (javax.naming.NamingEnumeration e_";
  protected final String TEXT_315 = " = attr_";
  protected final String TEXT_316 = "_";
  protected final String TEXT_317 = ".getAll(); e_";
  protected final String TEXT_318 = ".hasMore();){" + NL + "\t\t\t\t\t    \t\t\t\t \tlist_";
  protected final String TEXT_319 = ".add(e_";
  protected final String TEXT_320 = ".next());" + NL + "    \t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t    \t\t\t\t";
  protected final String TEXT_321 = ".";
  protected final String TEXT_322 = " = list_";
  protected final String TEXT_323 = ";";
  protected final String TEXT_324 = NL + "    \t\t\t\t\t\t\t\t\tStringBuilder attrStr_";
  protected final String TEXT_325 = " = new StringBuilder();" + NL + "\t\t\t\t\t\t    \t\t\tfor (javax.naming.NamingEnumeration e_";
  protected final String TEXT_326 = " = attr_";
  protected final String TEXT_327 = "_";
  protected final String TEXT_328 = ".getAll(); e_";
  protected final String TEXT_329 = ".hasMore();){" + NL + "\t\t\t\t\t    \t\t\t\tif(attrStr_";
  protected final String TEXT_330 = ".length()>0){" + NL + "    \t\t\t\t\t\t\t\t\t\tattrStr_";
  protected final String TEXT_331 = ".append(";
  protected final String TEXT_332 = ");" + NL + "\t\t\t\t\t    \t\t\t\t}" + NL + "    \t\t\t\t\t\t\t\t\tattrStr_";
  protected final String TEXT_333 = ".append(e_";
  protected final String TEXT_334 = ".next().toString());" + NL + "\t\t\t\t\t    \t\t\t}" + NL + "\t\t\t\t\t    \t\t\t";
  protected final String TEXT_335 = ".";
  protected final String TEXT_336 = " = attrStr_";
  protected final String TEXT_337 = ".toString();";
  protected final String TEXT_338 = "\t\t\t" + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_339 = ".";
  protected final String TEXT_340 = " = null;" + NL + "\t\t\t\t\t\t\t}";
  protected final String TEXT_341 = NL + "\t\t}//b" + NL + "\t} catch (java.lang.Exception e) {" + NL;
  protected final String TEXT_342 = NL + "        \tthrow(e);";
  protected final String TEXT_343 = "                    " + NL + "        \t\t";
  protected final String TEXT_344 = " = new ";
  protected final String TEXT_345 = "Struct();";
  protected final String TEXT_346 = NL + "       \t\t\t\t";
  protected final String TEXT_347 = ".";
  protected final String TEXT_348 = " = ";
  protected final String TEXT_349 = ".";
  protected final String TEXT_350 = ";";
  protected final String TEXT_351 = NL + "                ";
  protected final String TEXT_352 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_353 = ";";
  protected final String TEXT_354 = NL + "                ";
  protected final String TEXT_355 = " = null;";
  protected final String TEXT_356 = NL + "                System.err.println(e.getMessage());";
  protected final String TEXT_357 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_358 = " - \" + e.getMessage());";
  protected final String TEXT_359 = NL + "                ";
  protected final String TEXT_360 = " = null;";
  protected final String TEXT_361 = NL + "            \t";
  protected final String TEXT_362 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_363 = ";";
  protected final String TEXT_364 = NL + "    }";
  protected final String TEXT_365 = NL + "///////////////////////////////////        ";
  protected final String TEXT_366 = NL;

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
	
	List<Map<String, String>> fieldOptions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FIELD_OPTIONS__");
	boolean useFieldOptions = ("true").equals(ElementParameterParser.getValue(node, "__USE_FIELD_OPTIONS__"));
	List<IMetadataTable> metadatas = node.getMetadataList();
	    if ((metadatas!=null)&&(metadatas.size()>0)) {
	        IMetadataTable metadata = metadatas.get(0);	        
	        if(metadata!=null) {

				List<IMetadataColumn> columnList = metadata.getListColumns();
				String cid = node.getUniqueName();
				String filter=ElementParameterParser.getValue(node, "__FILTER__");
				String separator=ElementParameterParser.getValue(node, "__MULTI_VALUE_SEPARATOR__");
				boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));	
				boolean paging =("true").equals(ElementParameterParser.getValue(node, "__ISPAGING__"));	
				String pageSize =ElementParameterParser.getValue(node, "__PAGESIZE__");
				String limit =ElementParameterParser.getValue(node, "__LIMIT__");
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
if(("false").equals(useExistingConn)){
	String host=ElementParameterParser.getValue(node, "__HOST__");
	String port=ElementParameterParser.getValue(node, "__PORT__");
	String protocol=ElementParameterParser.getValue(node, "__PROTOCOL__");
	String advanced=ElementParameterParser.getValue(node, "__ADVANCEDCA__");
	String storepath=ElementParameterParser.getValue(node, "__STORECA__");
	String storepwd = ElementParameterParser.getValue(node, "__STORECAPWD__");
	boolean alwaysTrust = ("true").equals(ElementParameterParser.getValue(node, "__ALWAYS_TRUST__"));
	String referrals=ElementParameterParser.getValue(node, "__REFERRALS__");
	String aliases=ElementParameterParser.getValue(node, "__ALIASES__");
	boolean useAuth = "true".equals(ElementParameterParser.getValue(node, "__AUTHENTIFICATION__"));
	String user =ElementParameterParser.getValue(node, "__USER__");


    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(referrals);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(aliases);
    stringBuffer.append(TEXT_39);
    	
	if(baseDN == null || baseDN.length()<=2){

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_43);
    
	}else{

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_47);
    
	}
    if(("LDAPS").equals(protocol)){

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
	}
	if(("LDAPS").equals(protocol) || ("TLS").equals(protocol)){
		if(("true").equals(advanced)){
			if(alwaysTrust) {

    stringBuffer.append(TEXT_51);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    }
    stringBuffer.append(TEXT_54);
    
			} else {

    stringBuffer.append(TEXT_55);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(storepath );
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    stringBuffer.append(storepath);
    stringBuffer.append(TEXT_60);
    
				if(storepwd !=null && storepwd.length() !=0 ){
    stringBuffer.append(TEXT_61);
    
                    String passwordFieldName = "__STORECAPWD__";
                    
    stringBuffer.append(TEXT_62);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_65);
    } else {
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_68);
    }
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
				}
			}
		}
    }

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(TEXT_73);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_76);
    }
    stringBuffer.append(TEXT_77);
    if(useAuth){
    stringBuffer.append(TEXT_78);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    }
    stringBuffer.append(TEXT_81);
    
  String passwordFieldName = "__PASS__";
  
    stringBuffer.append(TEXT_82);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_85);
    } else {
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_88);
    }
    }
    stringBuffer.append(TEXT_89);
    
	//the authentication is being performed after establishment of the TLS session
	if(!"TLS".equals(protocol)){
		//we only keep the logic like before now, we may need to move it in the "useAuth" block.

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
		if(useAuth){

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    
		}
	}

    stringBuffer.append(TEXT_97);
    if(!cid.contains("tLDAPInput")){
    stringBuffer.append(TEXT_98);
    }
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
if("TLS".equals(protocol)){

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    if(useAuth){
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    }
    
}

    stringBuffer.append(TEXT_115);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_118);
    }
    
}else{

    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(exConn);
    stringBuffer.append(TEXT_121);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    }
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(exConnBaseDN);
    stringBuffer.append(TEXT_128);
    
}

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    
	boolean isDynamic = metadata.isDynamicSchema();
    if(isDynamic){

    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    
	}else{

    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    
					for(IMetadataColumn column:columnList){		

    stringBuffer.append(TEXT_136);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_137);
    
                	}

    stringBuffer.append(TEXT_138);
    
	}

    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(limit );
    stringBuffer.append(TEXT_143);
    
				if(("false").equals(useExistingConn)){
					if(baseDN == null || baseDN.length()<=2){

    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    
					}else{

    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(baseDN);
    stringBuffer.append(TEXT_161);
    
					}
				}

    
	String binaryColumns = "";
	boolean hasDynamicBinary=false;
	if(useFieldOptions){
		for(int i = 0;i<fieldOptions.size();i++){// search in the configuration table
			Map<String, String> line = fieldOptions.get(i);
			String columnName = line.get("SCHEMA_COLUMN");
			Boolean isBinary = "true".equals(line.get("BINARY"));
			if(isBinary){
				IMetadataColumn column = columnList.get(i);
				if(!column.getTalendType().equals("id_Dynamic")){
					if(binaryColumns.length()>0){
						binaryColumns+=" ";
					}
					binaryColumns+=column.getOriginalDbColumnName();
				}else{
					hasDynamicBinary = true;
				}
			}
		}
	}
	boolean hasBinaryColumn = binaryColumns.length()>0 || hasDynamicBinary;
	if(hasBinaryColumn){

    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(binaryColumns);
    stringBuffer.append(TEXT_164);
    
	}
    if(isDynamic){
    	String columnsStr = "";
		for(IMetadataColumn column:columnList){
			columnsStr += column.getOriginalDbColumnName() + ",";
		}

    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(columnsStr);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    if(("false").equals(useExistingConn)){
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(TEXT_173);
    }
    stringBuffer.append(TEXT_174);
    stringBuffer.append(filter);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    }
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
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
    stringBuffer.append(metadata.getDynamicColumn().getOriginalDbColumnName());
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
    
							if(hasDynamicBinary){
								if(binaryColumns.length()==0){

    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    
								}else{

    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    
								}

    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    
							}

    stringBuffer.append(TEXT_218);
    
	}

    if(paging){
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(pageSize );
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
    }
    
	if(hasBinaryColumn){

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    
	}

    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    if(("false").equals(useExistingConn)){
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(TEXT_239);
    }
    stringBuffer.append(TEXT_240);
    stringBuffer.append(filter);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    }
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    
	List< ? extends IConnection> conns = node.getOutgoingConnections(EConnectionType.FLOW_MAIN);
	if(conns.size() == 0){
		conns = node.getOutgoingConnections(EConnectionType.FLOW_MERGE);
	}
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
        		if(i==0){
        			firstConnName = connTemp.getName();
        		}
        		if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_247);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_248);
    
				}
			}
		}
	}

    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    
	if(firstConnName.length()>0){

    stringBuffer.append(TEXT_252);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_254);
    
	}

    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    
            if (conns!=null) {//1
                if (conns.size()>0) {//2
                    IConnection conn = conns.get(0); //the first connection
                    firstConnName = conn.getName();         
                    if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//3
                        
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    
					for(IMetadataColumn column:columnList){//5		
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_266);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_270);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_272);
    
						}else{
							if("dn".equals(column.getLabel().toLowerCase())){

    stringBuffer.append(TEXT_273);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_274);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    
							}else{

    
							if("id_Dynamic".equals(column.getTalendType())) {

    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_303);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    
							}else{

    stringBuffer.append(TEXT_306);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_310);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    
									if(javaType == JavaTypesManager.LIST){

    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    				
									} else {

    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    
								}

    stringBuffer.append(TEXT_338);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_340);
    
								}
							}
						}
                	}//5

    stringBuffer.append(TEXT_341);
    
        if (dieOnError) {

    stringBuffer.append(TEXT_342);
    
        } else {
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_343);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_345);
    
                for(IMetadataColumn column : metadata.getListColumns()) {

    stringBuffer.append(TEXT_346);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_348);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_350);
    
                }

    stringBuffer.append(TEXT_351);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_353);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_355);
    
            } else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_356);
    
				if(isLog4jEnabled){

    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    
				}

    stringBuffer.append(TEXT_359);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_360);
    
            } else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_361);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_363);
    
			}
        }

    stringBuffer.append(TEXT_364);
    
        }//3
    }//2
    
}//1


    stringBuffer.append(TEXT_365);
    
  }
}  
 
    stringBuffer.append(TEXT_366);
    return stringBuffer.toString();
  }
}
