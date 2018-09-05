package org.talend.designer.codegen.translators.business.microsoft_crm;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMicrosoftCrmInputBeginJava
{
  protected static String nl;
  public static synchronized TMicrosoftCrmInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMicrosoftCrmInputBeginJava result = new TMicrosoftCrmInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tint nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "\t" + NL + "\tint reConnMaxNum_";
  protected final String TEXT_4 = "=";
  protected final String TEXT_5 = ";" + NL + "\treConnMaxNum_";
  protected final String TEXT_6 = " = reConnMaxNum_";
  protected final String TEXT_7 = " >= 0 ? reConnMaxNum_";
  protected final String TEXT_8 = " : 0;";
  protected final String TEXT_9 = NL + "class CrmClass2JavaClassHelper{" + NL + "    public Object extractValue(Object obj){" + NL + "        Object value = null;" + NL + "        if(obj instanceof com.microsoft.schemas.xrm._2011.contracts.OptionSetValue){" + NL + "            //Integer" + NL + "            value = ((com.microsoft.schemas.xrm._2011.contracts.OptionSetValue)obj).getValue();" + NL + "        }else if(obj instanceof com.microsoft.schemas._2003._10.serialization.Guid){" + NL + "            //String" + NL + "            value = ((com.microsoft.schemas._2003._10.serialization.Guid)obj).getValue();" + NL + "        }else if(obj instanceof com.microsoft.schemas.xrm._2011.contracts.Money){" + NL + "            //BigDecimal" + NL + "            value = ((com.microsoft.schemas.xrm._2011.contracts.Money)obj).getValue();" + NL + "        }else if(obj instanceof com.microsoft.schemas.xrm._2011.contracts.EntityReference){" + NL + "            //JOSN String" + NL + "            com.microsoft.schemas.xrm._2011.contracts.EntityReference entityRef = (com.microsoft.schemas.xrm._2011.contracts.EntityReference)obj;" + NL + "            StringBuilder strBuilder = new StringBuilder(\"{\\\"guid\\\":\\\"\");" + NL + "                          strBuilder.append(entityRef.getId().getValue());" + NL + "                          strBuilder.append(\"\\\",\\\"logical_name\\\":\\\"\");" + NL + "                          strBuilder.append(entityRef.getLogicalName());" + NL + "                          strBuilder.append(\"\\\",\\\"name\\\":\\\"\");" + NL + "                          strBuilder.append(entityRef.getName());" + NL + "                          strBuilder.append(\"\\\"}\");" + NL + "           value = strBuilder.toString();" + NL + "        }else if(obj instanceof com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl){" + NL + "            //java.util.Date" + NL + "            value = ((com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl)obj).toGregorianCalendar().getTime();" + NL + "        }else{" + NL + "           //Object (EntityCollection)" + NL + "           value = obj;" + NL + "        }" + NL + "        return value;" + NL + "    }" + NL + "}" + NL + "" + NL + "CrmClass2JavaClassHelper crmClazzHelper_";
  protected final String TEXT_10 = " = new CrmClass2JavaClassHelper();" + NL;
  protected final String TEXT_11 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_12 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_15 = " = ";
  protected final String TEXT_16 = "; ";
  protected final String TEXT_17 = NL + "                    System.setProperty(\"javax.net.ssl.trustStore\", ";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "                    com.talend.microsoft.crm._2015_.utils.MsCrmWsdl" + NL + "                                         msCrmWsdl_";
  protected final String TEXT_20 = " = new com.talend.microsoft.crm._2015_.utils.MsCrmWsdl(";
  protected final String TEXT_21 = NL + "                                         ";
  protected final String TEXT_22 = ", ";
  protected final String TEXT_23 = NL + "                                         );" + NL + "                    com.talend.microsoft.crm._2015_.utils.DynamicsCRMConnector" + NL + "                                        crmConnector_";
  protected final String TEXT_24 = " = new com.talend.microsoft.crm._2015_.utils.DynamicsCRMConnector(";
  protected final String TEXT_25 = NL + "                                        ";
  protected final String TEXT_26 = ", decryptedPassword_";
  protected final String TEXT_27 = ", msCrmWsdl_";
  protected final String TEXT_28 = NL + "                                        );" + NL + "                   com.microsoft.schemas.xrm._2011.contracts.services.IOrganizationService" + NL + "                                                   iorgService_";
  protected final String TEXT_29 = " = crmConnector_";
  protected final String TEXT_30 = ".getOrganizationService();" + NL;
  protected final String TEXT_31 = NL + "                    com.microsoft.schemas.xrm._2011.contracts.QueryExpression" + NL + "                                                    queryExp_";
  protected final String TEXT_32 = " = new com.microsoft.schemas.xrm._2011.contracts.QueryExpression();" + NL + "                    com.microsoft.schemas.xrm._2011.contracts.ColumnSet" + NL + "                                                    columnSet_";
  protected final String TEXT_33 = " = new com.microsoft.schemas.xrm._2011.contracts.ColumnSet();" + NL + "                    com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring" + NL + "                                                    arrOfStr_";
  protected final String TEXT_34 = " = new com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring();" + NL;
  protected final String TEXT_35 = NL + "                       com.microsoft.schemas.xrm._2011.contracts.FilterExpression" + NL + "                                     filterExp_";
  protected final String TEXT_36 = " = new com.microsoft.schemas.xrm._2011.contracts.FilterExpression();" + NL + "                       com.microsoft.schemas.xrm._2011.contracts.ArrayOfConditionExpression" + NL + "                                     arrOfAnyConditionExp_";
  protected final String TEXT_37 = " = new com.microsoft.schemas.xrm._2011.contracts.ArrayOfConditionExpression();" + NL;
  protected final String TEXT_38 = NL + "                        com.microsoft.schemas.xrm._2011.contracts.ConditionExpression" + NL + "                                      conditionExp_";
  protected final String TEXT_39 = " = new com.microsoft.schemas.xrm._2011.contracts.ConditionExpression();" + NL + "                                      conditionExp_";
  protected final String TEXT_40 = ".setAttributeName(\"";
  protected final String TEXT_41 = "\");" + NL + "                                      conditionExp_";
  protected final String TEXT_42 = ".setOperator(" + NL + "                                            com.microsoft.schemas.xrm._2011.contracts.ConditionOperator.fromValue(" + NL + "                                            \"";
  protected final String TEXT_43 = "\"));" + NL + "                        com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfanyType" + NL + "                                      arrOfAnyType_";
  protected final String TEXT_44 = " = new com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfanyType();" + NL + "                                      arrOfAnyType_";
  protected final String TEXT_45 = ".getAnyTypes().add(";
  protected final String TEXT_46 = ");" + NL + "                                      conditionExp_";
  protected final String TEXT_47 = ".setValues(arrOfAnyType_";
  protected final String TEXT_48 = ");" + NL + "                                      arrOfAnyConditionExp_";
  protected final String TEXT_49 = ".getConditionExpressions().add(conditionExp_";
  protected final String TEXT_50 = ");" + NL;
  protected final String TEXT_51 = NL + "                                      filterExp_";
  protected final String TEXT_52 = ".setConditions(arrOfAnyConditionExp_";
  protected final String TEXT_53 = ");" + NL + "                                      filterExp_";
  protected final String TEXT_54 = ".setFilterOperator(" + NL + "                                                    com.microsoft.schemas.xrm._2011.contracts.LogicalOperator.fromValue(\"";
  protected final String TEXT_55 = "\")" + NL + "                                                    );" + NL + "                                      queryExp_";
  protected final String TEXT_56 = ".setCriteria(filterExp_";
  protected final String TEXT_57 = ");";
  protected final String TEXT_58 = NL + "                                                    arrOfStr_";
  protected final String TEXT_59 = ".getStrings().addAll(" + NL + "                                                            java.util.Arrays.asList(";
  protected final String TEXT_60 = ")" + NL + "                                                    );" + NL + "                                      columnSet_";
  protected final String TEXT_61 = ".setColumns(arrOfStr_";
  protected final String TEXT_62 = ");" + NL + "                                      queryExp_";
  protected final String TEXT_63 = ".setColumnSet(columnSet_";
  protected final String TEXT_64 = ");" + NL + "                                      queryExp_";
  protected final String TEXT_65 = ".setEntityName(\"";
  protected final String TEXT_66 = "\");" + NL;
  protected final String TEXT_67 = NL + "                \tcom.microsoft.schemas.xrm._2011.contracts.PagingInfo pagingInfo_";
  protected final String TEXT_68 = " = new com.microsoft.schemas.xrm._2011.contracts.PagingInfo();" + NL + "                \tint pageNumber_";
  protected final String TEXT_69 = " = 1;" + NL + "                \tpagingInfo_";
  protected final String TEXT_70 = ".setPageNumber(pageNumber_";
  protected final String TEXT_71 = ");" + NL + "" + NL + "                \tqueryExp_";
  protected final String TEXT_72 = ".setPageInfo(pagingInfo_";
  protected final String TEXT_73 = ");" + NL + "                \t" + NL + "                \tboolean fetchMore_";
  protected final String TEXT_74 = " = true;" + NL + "                \twhile (fetchMore_";
  protected final String TEXT_75 = ") {" + NL + "                \t" + NL + "                    com.microsoft.schemas.xrm._2011.contracts.EntityCollection" + NL + "                                  entityCollection_";
  protected final String TEXT_76 = " = iorgService_";
  protected final String TEXT_77 = ".retrieveMultiple(queryExp_";
  protected final String TEXT_78 = ");" + NL + "                                  " + NL + "                    String pagingCookie_";
  protected final String TEXT_79 = " = entityCollection_";
  protected final String TEXT_80 = ".getPagingCookie();" + NL + "                    fetchMore_";
  protected final String TEXT_81 = " = entityCollection_";
  protected final String TEXT_82 = ".isMoreRecords() != null" + NL + "                            ? entityCollection_";
  protected final String TEXT_83 = ".isMoreRecords() : false;" + NL + "                    List<com.microsoft.schemas.xrm._2011.contracts.Entity>" + NL + "                                  entityList_";
  protected final String TEXT_84 = " = entityCollection_";
  protected final String TEXT_85 = ".getEntities().getEntities();" + NL + "                    java.util.Map<String,Object> map_";
  protected final String TEXT_86 = " = new java.util.HashMap<String,Object>();" + NL + "                    //Entity For Loop Begin" + NL + "                    for(com.microsoft.schemas.xrm._2011.contracts.Entity entity: entityList_";
  protected final String TEXT_87 = "){" + NL + "                            nb_line_";
  protected final String TEXT_88 = " ++;" + NL + "                            map_";
  protected final String TEXT_89 = ".clear();" + NL + "                            List<org.datacontract.schemas._2004._07.system_collections.KeyValuePairOfstringanyType>" + NL + "                                     props = entity.getAttributes().getKeyValuePairOfstringanyTypes();" + NL + "                            for(org.datacontract.schemas._2004._07.system_collections.KeyValuePairOfstringanyType prop: props){" + NL + "                                String key = prop.getKey(); Object value = prop.getValue();" + NL + "                                map_";
  protected final String TEXT_90 = ".put(key,value);" + NL + "                            }";
  protected final String TEXT_91 = NL + "                                    if(map_";
  protected final String TEXT_92 = ".get(\"";
  protected final String TEXT_93 = "\") != null){" + NL + "                                        Object obj_";
  protected final String TEXT_94 = " = crmClazzHelper_";
  protected final String TEXT_95 = ".extractValue(map_";
  protected final String TEXT_96 = ".get(\"";
  protected final String TEXT_97 = "\"));";
  protected final String TEXT_98 = NL + "                                            ";
  protected final String TEXT_99 = ".";
  protected final String TEXT_100 = " = obj_";
  protected final String TEXT_101 = ".toString();";
  protected final String TEXT_102 = NL + "                                           ";
  protected final String TEXT_103 = ".";
  protected final String TEXT_104 = " = map_";
  protected final String TEXT_105 = ".get(\"";
  protected final String TEXT_106 = "\");";
  protected final String TEXT_107 = NL + "                                            if(obj_";
  protected final String TEXT_108 = " instanceof java.util.Date){";
  protected final String TEXT_109 = NL + "                                                 ";
  protected final String TEXT_110 = ".";
  protected final String TEXT_111 = " = (java.util.Date)obj_";
  protected final String TEXT_112 = ";" + NL + "                                            }else{";
  protected final String TEXT_113 = NL + "                                                 ";
  protected final String TEXT_114 = ".";
  protected final String TEXT_115 = " = ParserUtils.parseTo_Date(obj_";
  protected final String TEXT_116 = ".toString(), ";
  protected final String TEXT_117 = ");" + NL + "                                            }";
  protected final String TEXT_118 = NL + "                                            if(obj_";
  protected final String TEXT_119 = " instanceof java.lang.Integer){";
  protected final String TEXT_120 = NL + "                                                ";
  protected final String TEXT_121 = ".";
  protected final String TEXT_122 = " = (java.lang.Integer)obj_";
  protected final String TEXT_123 = ";" + NL + "                                            }else{";
  protected final String TEXT_124 = NL + "                                                ";
  protected final String TEXT_125 = ".";
  protected final String TEXT_126 = " = ParserUtils.parseTo_Integer(obj_";
  protected final String TEXT_127 = ".toString());" + NL + "                                            }";
  protected final String TEXT_128 = NL + "                                           if(obj_";
  protected final String TEXT_129 = " instanceof java.math.BigDecimal){";
  protected final String TEXT_130 = NL + "                                             ";
  protected final String TEXT_131 = ".";
  protected final String TEXT_132 = " = (java.math.BigDecimal)obj_";
  protected final String TEXT_133 = ";" + NL + "                                           }else{";
  protected final String TEXT_134 = NL + "                                             ";
  protected final String TEXT_135 = ".";
  protected final String TEXT_136 = " = ParserUtils.parseTo_BigDecimal(obj_";
  protected final String TEXT_137 = ".toString());" + NL + "                                           }";
  protected final String TEXT_138 = NL + "                                            ";
  protected final String TEXT_139 = ".";
  protected final String TEXT_140 = " = ParserUtils.parseTo_";
  protected final String TEXT_141 = "(obj_";
  protected final String TEXT_142 = ".toString());";
  protected final String TEXT_143 = NL + "                                    }else{";
  protected final String TEXT_144 = NL + "                                        ";
  protected final String TEXT_145 = ".";
  protected final String TEXT_146 = " = ";
  protected final String TEXT_147 = ";" + NL + "                                    }";
  protected final String TEXT_148 = NL + "\t\t\t\tString entitySetName_";
  protected final String TEXT_149 = "=";
  protected final String TEXT_150 = ";" + NL + "\t\t\t";
  protected final String TEXT_151 = NL + "\t\t\t\tString entitySetName_";
  protected final String TEXT_152 = "=\"";
  protected final String TEXT_153 = "\";" + NL + "\t\t\t";
  protected final String TEXT_154 = NL + "\t\t\t\tSystem.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.SimpleLog\");" + NL + "\t\t    \tSystem.setProperty(\"org.apache.commons.logging.simplelog.showdatetime\", \"true\");" + NL + "\t\t    \tSystem.setProperty(\"org.apache.commons.logging.simplelog.log.httpclient.wire\", \"debug\");" + NL + "\t\t    \tSystem.setProperty(\"org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient\", \"debug\");" + NL + "\t\t\t";
  protected final String TEXT_155 = NL + "\t\t\t\tSystem.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.NoOpLog\");" + NL + "\t\t\t";
  protected final String TEXT_156 = NL + NL + "\t\t\t";
  protected final String TEXT_157 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_158 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_159 = ");";
  protected final String TEXT_160 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_161 = " = ";
  protected final String TEXT_162 = "; ";
  protected final String TEXT_163 = NL + NL + "\t\t\t";
  protected final String TEXT_164 = NL + "\t\t\t    org.talend.ms.crm.odata.ClientConfiguration clientConfig_";
  protected final String TEXT_165 = " = org.talend.ms.crm.odata.ClientConfigurationFactory" + NL + "                        .buildNtlmClientConfiguration(";
  protected final String TEXT_166 = ", decryptedPassword_";
  protected final String TEXT_167 = ", ";
  protected final String TEXT_168 = ", ";
  protected final String TEXT_169 = ");" + NL + "\t\t\t";
  protected final String TEXT_170 = NL + "\t\t\t    org.talend.ms.crm.odata.ClientConfiguration clientConfig_";
  protected final String TEXT_171 = " = org.talend.ms.crm.odata.ClientConfigurationFactory" + NL + "                        .buildOAuthClientConfiguration(";
  protected final String TEXT_172 = ", ";
  protected final String TEXT_173 = ", decryptedPassword_";
  protected final String TEXT_174 = ", ";
  protected final String TEXT_175 = ");" + NL + "\t\t\t";
  protected final String TEXT_176 = NL + "\t\t\t\t" + NL + "\t\t\t\t" + NL + "\t\t\t\tclientConfig_";
  protected final String TEXT_177 = ".setTimeout(";
  protected final String TEXT_178 = ");" + NL + "\t\t\t\tclientConfig_";
  protected final String TEXT_179 = ".setMaxRetry(reConnMaxNum_";
  protected final String TEXT_180 = ",";
  protected final String TEXT_181 = ");" + NL + "\t\t\t\tclientConfig_";
  protected final String TEXT_182 = ".setReuseHttpClient(";
  protected final String TEXT_183 = ");" + NL + "\t\t\t\torg.talend.ms.crm.odata.DynamicsCRMClient client_";
  protected final String TEXT_184 = " = new org.talend.ms.crm.odata.DynamicsCRMClient(clientConfig_";
  protected final String TEXT_185 = ",";
  protected final String TEXT_186 = ",entitySetName_";
  protected final String TEXT_187 = ");" + NL + "\t\t\t\tString queryFilter_";
  protected final String TEXT_188 = "=null;" + NL + "\t\t\t\t";
  protected final String TEXT_189 = NL + "\t     \t\t\tqueryFilter_";
  protected final String TEXT_190 = "=";
  protected final String TEXT_191 = ";" + NL + "\t     \t\t";
  protected final String TEXT_192 = NL + "\t\t\t\t\t\tjava.util.List<String> fields_";
  protected final String TEXT_193 = " = new java.util.ArrayList<String>();" + NL + "\t\t\t\t\t\tjava.util.List<org.talend.ms.crm.odata.ConditionOperator> conditionOperators_";
  protected final String TEXT_194 = " = new java.util.ArrayList<org.talend.ms.crm.odata.ConditionOperator>();" + NL + "\t\t\t        \tjava.util.List<Object> values_";
  protected final String TEXT_195 = " = new java.util.ArrayList<Object>();" + NL + "\t\t            ";
  protected final String TEXT_196 = NL + "\t\t        \t\t\tfields_";
  protected final String TEXT_197 = ".add(\"";
  protected final String TEXT_198 = "\");" + NL + "\t\t        \t\t\tconditionOperators_";
  protected final String TEXT_199 = ".add(org.talend.ms.crm.odata.ConditionOperator.";
  protected final String TEXT_200 = ");" + NL + "\t\t        \t\t\tvalues_";
  protected final String TEXT_201 = ".add(";
  protected final String TEXT_202 = ");" + NL + "\t\t       \t\t";
  protected final String TEXT_203 = NL + "\t\t        \t\tqueryFilter_";
  protected final String TEXT_204 = "=org.talend.ms.crm.odata.QueryFilterUtil.getURIFilterString(org.talend.ms.crm.odata.LogicalOperator.";
  protected final String TEXT_205 = ", fields_";
  protected final String TEXT_206 = ", conditionOperators_";
  protected final String TEXT_207 = ", values_";
  protected final String TEXT_208 = ");" + NL + "\t\t        \t";
  protected final String TEXT_209 = NL + "\t     \t\t\tString orderBy_";
  protected final String TEXT_210 = "=\"";
  protected final String TEXT_211 = "\";" + NL + "\t     \t\t\t";
  protected final String TEXT_212 = NL + "\t\t\t\t\torg.talend.ms.crm.odata.QueryOptionConfig queryOption_";
  protected final String TEXT_213 = " = new org.talend.ms.crm.odata.QueryOptionConfig();" + NL + "\t\t        \tqueryOption_";
  protected final String TEXT_214 = ".setReturnEntityProperties(new String[]{";
  protected final String TEXT_215 = "});" + NL + "\t\t        \t//TODO need to support top(limit)?" + NL + "\t\t        \t// queryOption_";
  protected final String TEXT_216 = ".setTop(5000);" + NL + "\t\t\t\t\tqueryOption_";
  protected final String TEXT_217 = ".setFilter(queryFilter_";
  protected final String TEXT_218 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_219 = NL + "\t\t\t\t\t\tqueryOption_";
  protected final String TEXT_220 = ".setOrderBy(orderBy_";
  protected final String TEXT_221 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_222 = NL + "\t\t\t\t   java.net.URI nextPageURI_";
  protected final String TEXT_223 = "=null;" + NL + "\t\t        \twhile(true){" + NL + "\t\t        \t\torg.apache.olingo.client.api.communication.request.retrieve.ODataEntitySetRequest<org.apache.olingo.client.api.domain.ClientEntitySet> request_";
  protected final String TEXT_224 = " = client_";
  protected final String TEXT_225 = ".createEntityRetrieveRequest(queryOption_";
  protected final String TEXT_226 = ");" + NL + "\t\t        \t\tif(nextPageURI_";
  protected final String TEXT_227 = "!=null){" + NL + "\t\t        \t\t\trequest_";
  protected final String TEXT_228 = ".setURI(nextPageURI_";
  protected final String TEXT_229 = ");" + NL + "\t\t        \t\t}" + NL + "\t\t        \t\torg.apache.olingo.client.api.communication.response.ODataRetrieveResponse<org.apache.olingo.client.api.domain.ClientEntitySet> response_";
  protected final String TEXT_230 = " = request_";
  protected final String TEXT_231 = ".execute();" + NL + "        \t\t\t\torg.apache.olingo.client.api.domain.ClientEntitySet clientEntitySet_";
  protected final String TEXT_232 = " = response_";
  protected final String TEXT_233 = ".getBody();" + NL + "\t\t        \t\tfor (org.apache.olingo.client.api.domain.ClientEntity entity_";
  protected final String TEXT_234 = ":clientEntitySet_";
  protected final String TEXT_235 = ".getEntities()) {" + NL + "\t\t               nb_line_";
  protected final String TEXT_236 = "++;" + NL + "\t                  ";
  protected final String TEXT_237 = NL + "\t\t\t\t\t\t\t\torg.apache.olingo.client.api.domain.ClientProperty property_";
  protected final String TEXT_238 = "_";
  protected final String TEXT_239 = " =entity_";
  protected final String TEXT_240 = ".getProperty(\"";
  protected final String TEXT_241 = "\");" + NL + "\t\t\t\t\t\t\t\tif(property_";
  protected final String TEXT_242 = "_";
  protected final String TEXT_243 = "!=null && !property_";
  protected final String TEXT_244 = "_";
  protected final String TEXT_245 = ".hasNullValue()){" + NL + "\t\t        \t\t\t\t\t";
  protected final String TEXT_246 = NL + "\t\t        \t\t\t\t\t\t";
  protected final String TEXT_247 = ".";
  protected final String TEXT_248 = " = property_";
  protected final String TEXT_249 = "_";
  protected final String TEXT_250 = ".getValue().toString();" + NL + "\t\t        \t\t\t\t\t";
  protected final String TEXT_251 = NL + "\t\t        \t\t\t\t\t\t";
  protected final String TEXT_252 = ".";
  protected final String TEXT_253 = " = ParserUtils.parseTo_Date(property_";
  protected final String TEXT_254 = "_";
  protected final String TEXT_255 = ".getValue().toString(), ";
  protected final String TEXT_256 = ");" + NL + "\t\t        \t\t\t\t\t";
  protected final String TEXT_257 = NL + "\t\t        \t\t\t\t\t    String property_";
  protected final String TEXT_258 = "_";
  protected final String TEXT_259 = "_type = property_";
  protected final String TEXT_260 = "_";
  protected final String TEXT_261 = ".getValue().getTypeName();" + NL + "\t\t        \t\t\t\t\t\tif(\"Edm.Binary\".equals(property_";
  protected final String TEXT_262 = "_";
  protected final String TEXT_263 = "_type)){" + NL + "\t\t        \t\t\t\t\t\t    ";
  protected final String TEXT_264 = ".";
  protected final String TEXT_265 = " = (byte[])property_";
  protected final String TEXT_266 = "_";
  protected final String TEXT_267 = ".getValue().asPrimitive().toValue();" + NL + "\t\t        \t\t\t\t\t\t}" + NL + "\t\t        \t\t\t\t\t\telse{" + NL + "\t\t        \t\t\t\t\t\t    org.apache.olingo.commons.api.edm.EdmPrimitiveType edmpt = org.apache.olingo.commons.core.edm.primitivetype.EdmPrimitiveTypeFactory.getInstance(org.apache.olingo.commons.api.edm.EdmPrimitiveTypeKind.Binary);";
  protected final String TEXT_268 = NL + "                                            ";
  protected final String TEXT_269 = ".";
  protected final String TEXT_270 = " = (byte[])edmpt.valueOfString(property_";
  protected final String TEXT_271 = "_";
  protected final String TEXT_272 = ".getValue().toString(), null, null, org.apache.olingo.commons.api.Constants.DEFAULT_PRECISION, org.apache.olingo.commons.api.Constants.DEFAULT_SCALE, null, byte[].class);" + NL + "\t\t        \t\t\t\t\t\t}" + NL + "\t\t        \t\t\t\t\t";
  protected final String TEXT_273 = NL + "\t\t        \t\t\t\t\t\t";
  protected final String TEXT_274 = ".";
  protected final String TEXT_275 = " = ParserUtils.parseTo_";
  protected final String TEXT_276 = "(property_";
  protected final String TEXT_277 = "_";
  protected final String TEXT_278 = ".getValue().toString());" + NL + "\t\t        \t\t\t\t\t";
  protected final String TEXT_279 = NL + "\t        \t\t\t\t\t}else{" + NL + "\t        \t\t\t\t\t\t";
  protected final String TEXT_280 = ".";
  protected final String TEXT_281 = " = ";
  protected final String TEXT_282 = ";" + NL + "\t        \t\t\t\t\t}" + NL + "\t        \t\t\t\t";
  protected final String TEXT_283 = NL + "\t\t\t\t";
  protected final String TEXT_284 = NL + "\t\t\tSystem.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.SimpleLog\");" + NL + "\t\t    System.setProperty(\"org.apache.commons.logging.simplelog.showdatetime\", \"true\");" + NL + "\t\t    System.setProperty(\"org.apache.commons.logging.simplelog.log.httpclient.wire\", \"debug\");" + NL + "\t\t    System.setProperty(\"org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient\", \"debug\");" + NL + "\t\t\t";
  protected final String TEXT_285 = NL + "\t\t\tSystem.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.NoOpLog\");" + NL + "\t\t\t";
  protected final String TEXT_286 = NL + NL + "\t\t\t";
  protected final String TEXT_287 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_288 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_289 = ");";
  protected final String TEXT_290 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_291 = " = ";
  protected final String TEXT_292 = "; ";
  protected final String TEXT_293 = NL + NL + "\t\t\t";
  protected final String TEXT_294 = NL + "\t\t\t\t\torg.apache.commons.httpclient.auth.AuthPolicy.registerAuthScheme(org.apache.commons.httpclient.auth.AuthPolicy.NTLM, org.talend.mscrm.login.ntlm.JCIFS_NTLMScheme.class);" + NL + "" + NL + "\t\t\t\t\tcom.microsoft.crm4.webserviceTest.CrmServiceStub service_";
  protected final String TEXT_295 = " = new com.microsoft.crm4.webserviceTest.CrmServiceStub(";
  protected final String TEXT_296 = ");" + NL + "\t\t\t\t\torg.apache.axis2.client.Options options_";
  protected final String TEXT_297 = " = service_";
  protected final String TEXT_298 = "._getServiceClient().getOptions();" + NL + "\t\t\t\t\torg.apache.axis2.transport.http.HttpTransportProperties.Authenticator auth_";
  protected final String TEXT_299 = " = new org.apache.axis2.transport.http.HttpTransportProperties.Authenticator();" + NL + "" + NL + "\t\t\t\t\tList<String> authSchemes_";
  protected final String TEXT_300 = " = new java.util.ArrayList<String>();" + NL + "\t\t\t\t\tauthSchemes_";
  protected final String TEXT_301 = ".add(org.apache.axis2.transport.http.HttpTransportProperties.Authenticator.NTLM);" + NL + "\t\t\t\t\tauth_";
  protected final String TEXT_302 = " .setAuthSchemes(authSchemes_";
  protected final String TEXT_303 = ");" + NL + "" + NL + "\t\t            auth_";
  protected final String TEXT_304 = " .setUsername(";
  protected final String TEXT_305 = ");" + NL + "\t\t            auth_";
  protected final String TEXT_306 = " .setPassword(decryptedPassword_";
  protected final String TEXT_307 = ");" + NL + "\t\t            auth_";
  protected final String TEXT_308 = " .setHost(";
  protected final String TEXT_309 = ");" + NL + "\t\t            auth_";
  protected final String TEXT_310 = " .setPort(";
  protected final String TEXT_311 = ");" + NL + "\t\t            auth_";
  protected final String TEXT_312 = " .setDomain(";
  protected final String TEXT_313 = ");" + NL + "\t\t            auth_";
  protected final String TEXT_314 = " .setPreemptiveAuthentication(false);" + NL + "" + NL + "\t\t            options_";
  protected final String TEXT_315 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.AUTHENTICATE, auth_";
  protected final String TEXT_316 = ");" + NL + "\t\t           \toptions_";
  protected final String TEXT_317 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.REUSE_HTTP_CLIENT, \"";
  protected final String TEXT_318 = "\");" + NL + "" + NL + "" + NL + "\t\t            options_";
  protected final String TEXT_319 = " .setUserName(";
  protected final String TEXT_320 = ");" + NL + "\t\t            options_";
  protected final String TEXT_321 = " .setPassword(decryptedPassword_";
  protected final String TEXT_322 = ");" + NL + "\t\t            options_";
  protected final String TEXT_323 = " .setTimeOutInMilliSeconds(Long.valueOf(";
  protected final String TEXT_324 = "));" + NL + "" + NL + "\t\t            options_";
  protected final String TEXT_325 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.SO_TIMEOUT,new Integer(";
  protected final String TEXT_326 = "));" + NL + "\t\t            options_";
  protected final String TEXT_327 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.CONNECTION_TIMEOUT, new Integer(";
  protected final String TEXT_328 = "));" + NL + "" + NL + "\t\t            com.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument catd_";
  protected final String TEXT_329 = " = com.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument.Factory.newInstance();" + NL + "\t\t            com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken token_";
  protected final String TEXT_330 = " = com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken.Factory.newInstance();" + NL + "\t\t            token_";
  protected final String TEXT_331 = ".setAuthenticationType(0);" + NL + "\t\t            token_";
  protected final String TEXT_332 = ".setOrganizationName(";
  protected final String TEXT_333 = ");" + NL + "\t\t            catd_";
  protected final String TEXT_334 = ".setCrmAuthenticationToken(token_";
  protected final String TEXT_335 = ");" + NL + "\t\t        ";
  protected final String TEXT_336 = NL + "\t\t        \tcom.microsoft.crm4.webserviceTest.CrmServiceStub service_";
  protected final String TEXT_337 = " = new com.microsoft.crm4.webserviceTest.CrmServiceStub(\"https://\" + ";
  protected final String TEXT_338 = " + \"/MSCrmServices/2007/CrmService.asmx\");" + NL + "\t\t\t\t\torg.apache.axis2.client.Options options_";
  protected final String TEXT_339 = " = service_";
  protected final String TEXT_340 = "._getServiceClient().getOptions();" + NL + "\t\t        \torg.talend.mscrm.login.passport.MsDynamicsWrapper msDynamicsWrapper_";
  protected final String TEXT_341 = " = new org.talend.mscrm.login.passport.MsDynamicsWrapper(";
  protected final String TEXT_342 = ",";
  protected final String TEXT_343 = ",";
  protected final String TEXT_344 = ",decryptedPassword_";
  protected final String TEXT_345 = ");" + NL + "\t\t\t\t\tmsDynamicsWrapper_";
  protected final String TEXT_346 = ".connect();" + NL + "\t\t\t\t\tString crmTicket_";
  protected final String TEXT_347 = " = msDynamicsWrapper_";
  protected final String TEXT_348 = ".getCrmTicket();" + NL + "" + NL + "\t\t        \toptions_";
  protected final String TEXT_349 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.REUSE_HTTP_CLIENT, \"";
  protected final String TEXT_350 = "\");" + NL + "\t\t        \toptions_";
  protected final String TEXT_351 = " .setTimeOutInMilliSeconds(Long.valueOf(";
  protected final String TEXT_352 = "));" + NL + "" + NL + "\t\t            options_";
  protected final String TEXT_353 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.SO_TIMEOUT,new Integer(";
  protected final String TEXT_354 = "));" + NL + "\t\t            options_";
  protected final String TEXT_355 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.CONNECTION_TIMEOUT, new Integer(";
  protected final String TEXT_356 = "));" + NL + "" + NL + "\t\t        \tcom.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument catd_";
  protected final String TEXT_357 = " = com.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument.Factory.newInstance();" + NL + "\t\t            com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken token_";
  protected final String TEXT_358 = " = com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken.Factory.newInstance();" + NL + "\t\t            token_";
  protected final String TEXT_359 = ".setAuthenticationType(1);" + NL + "\t\t            token_";
  protected final String TEXT_360 = ".setOrganizationName(";
  protected final String TEXT_361 = ");" + NL + "\t\t            token_";
  protected final String TEXT_362 = ".setCrmTicket(crmTicket_";
  protected final String TEXT_363 = ");" + NL + "\t\t            catd_";
  protected final String TEXT_364 = ".setCrmAuthenticationToken(token_";
  protected final String TEXT_365 = ");" + NL + "\t\t        ";
  protected final String TEXT_366 = NL + NL + "\t     \t\t";
  protected final String TEXT_367 = NL + "\t        \tcom.microsoft.schemas.crm._2006.query.QueryExpression query_";
  protected final String TEXT_368 = " = com.microsoft.schemas.crm._2006.query.QueryExpression.Factory.newInstance();" + NL + "\t        \tcom.microsoft.schemas.crm._2006.query.ColumnSet cols_";
  protected final String TEXT_369 = " = com.microsoft.schemas.crm._2006.query.ColumnSet.Factory.newInstance();" + NL + "\t        \tcom.microsoft.schemas.crm._2006.query.ArrayOfString aos_";
  protected final String TEXT_370 = " = com.microsoft.schemas.crm._2006.query.ArrayOfString.Factory.newInstance();" + NL + "\t       \t\t";
  protected final String TEXT_371 = NL + "\t            \t\tcom.microsoft.schemas.crm._2006.query.ConditionExpression condition_";
  protected final String TEXT_372 = " = com.microsoft.schemas.crm._2006.query.ConditionExpression.Factory.newInstance();" + NL + "\t            \t\tcondition_";
  protected final String TEXT_373 = ".setAttributeName(\"";
  protected final String TEXT_374 = "\");" + NL + "\t            \t\tcondition_";
  protected final String TEXT_375 = ".setOperator(com.microsoft.schemas.crm._2006.query.ConditionOperator.Enum.forString(\"";
  protected final String TEXT_376 = "\"));" + NL + "\t        \t\t\t";
  protected final String TEXT_377 = NL + "\t            \t\t\tcom.microsoft.schemas.crm._2006.query.ArrayOfAnyType values_";
  protected final String TEXT_378 = " = com.microsoft.schemas.crm._2006.query.ArrayOfAnyType.Factory.newInstance();" + NL + "\t            \t\t\torg.xmlsoap.schemas.soap.encoding.String StringValue_";
  protected final String TEXT_379 = " = org.xmlsoap.schemas.soap.encoding.String.Factory.newInstance();" + NL + "\t            \t\t\tStringValue_";
  protected final String TEXT_380 = ".setStringValue(";
  protected final String TEXT_381 = ");" + NL + "\t            \t\t\tvalues_";
  protected final String TEXT_382 = ".setValueArray(new org.xmlsoap.schemas.soap.encoding.String[] { StringValue_";
  protected final String TEXT_383 = " });" + NL + "\t            \t\t\tcondition_";
  protected final String TEXT_384 = ".setValues(values_";
  protected final String TEXT_385 = ");" + NL + "\t       \t\t\t\t";
  protected final String TEXT_386 = NL + "\t        \t\tcom.microsoft.schemas.crm._2006.query.ArrayOfConditionExpression conditions_";
  protected final String TEXT_387 = " = com.microsoft.schemas.crm._2006.query.ArrayOfConditionExpression.Factory.newInstance();" + NL + "\t        \t\tconditions_";
  protected final String TEXT_388 = ".setConditionArray(new com.microsoft.schemas.crm._2006.query.ConditionExpression[] { ";
  protected final String TEXT_389 = " });" + NL + "\t        \t\t";
  protected final String TEXT_390 = NL + "\t        \t\t\tcom.microsoft.schemas.crm._2006.query.FilterExpression filter_";
  protected final String TEXT_391 = " = com.microsoft.schemas.crm._2006.query.FilterExpression.Factory.newInstance();" + NL + "\t        \t\t\tfilter_";
  protected final String TEXT_392 = ".setFilterOperator(com.microsoft.schemas.crm._2006.query.LogicalOperator.Enum.forString(\"";
  protected final String TEXT_393 = "\"));" + NL + "\t        \t\t\tfilter_";
  protected final String TEXT_394 = ".setConditions(conditions_";
  protected final String TEXT_395 = ");" + NL + "\t        \t\t\tquery_";
  protected final String TEXT_396 = ".setCriteria(filter_";
  protected final String TEXT_397 = ");" + NL + "\t       \t\t\t";
  protected final String TEXT_398 = NL + NL + "\t        \t";
  protected final String TEXT_399 = NL + "\t        \taos_";
  protected final String TEXT_400 = ".setAttributeArray(new String[]{";
  protected final String TEXT_401 = "});" + NL + "\t        \tcols_";
  protected final String TEXT_402 = ".setAttributes(aos_";
  protected final String TEXT_403 = ");" + NL + "\t        \tquery_";
  protected final String TEXT_404 = ".setColumnSet(cols_";
  protected final String TEXT_405 = ");" + NL + "\t        \tquery_";
  protected final String TEXT_406 = ".setEntityName(\"";
  protected final String TEXT_407 = "\");" + NL + "" + NL + "\t        \tcom.microsoft.schemas.crm._2006.query.PagingInfo pagingInfo_";
  protected final String TEXT_408 = " = com.microsoft.schemas.crm._2006.query.PagingInfo.Factory.newInstance();" + NL + "\t        \tint pageNumber_";
  protected final String TEXT_409 = " = 1;" + NL + "\t        \tpagingInfo_";
  protected final String TEXT_410 = ".setPageNumber(pageNumber_";
  protected final String TEXT_411 = ");" + NL + "\t        \t";
  protected final String TEXT_412 = NL + "\t        \tpagingInfo_";
  protected final String TEXT_413 = ".setCount(5);" + NL + "\t        \t";
  protected final String TEXT_414 = NL + "\t        \tquery_";
  protected final String TEXT_415 = ".setPageInfo(pagingInfo_";
  protected final String TEXT_416 = ");" + NL + "" + NL + "\t        \tcom.microsoft.schemas.crm._2007.webservices.RetrieveMultipleRequest rmr_";
  protected final String TEXT_417 = " = com.microsoft.schemas.crm._2007.webservices.RetrieveMultipleRequest.Factory.newInstance();" + NL + "\t        \tcom.microsoft.schemas.crm._2007.webservices.ExecuteDocument.Execute execute_";
  protected final String TEXT_418 = " = com.microsoft.schemas.crm._2007.webservices.ExecuteDocument.Execute.Factory.newInstance();" + NL + "\t        \tcom.microsoft.schemas.crm._2007.webservices.ExecuteDocument executeDoc_";
  protected final String TEXT_419 = " = com.microsoft.schemas.crm._2007.webservices.ExecuteDocument.Factory.newInstance();" + NL + "\t        \trmr_";
  protected final String TEXT_420 = ".setReturnDynamicEntities(true);" + NL + "\t        \trmr_";
  protected final String TEXT_421 = ".setQuery(query_";
  protected final String TEXT_422 = ");" + NL + "\t        \texecute_";
  protected final String TEXT_423 = ".setRequest(rmr_";
  protected final String TEXT_424 = ");" + NL + "\t        \texecuteDoc_";
  protected final String TEXT_425 = ".setExecute(execute_";
  protected final String TEXT_426 = ");" + NL + "\t        \texecuteDoc_";
  protected final String TEXT_427 = " = com.microsoft.schemas.crm._2007.webservices.ExecuteDocument.Factory.parse(executeDoc_";
  protected final String TEXT_428 = ".toString());" + NL + "\t        \tcom.microsoft.schemas.crm._2007.webservices.ExecuteResponseDocument result_";
  protected final String TEXT_429 = ";" + NL + "\t        \tboolean fetchMore_";
  protected final String TEXT_430 = " = true;" + NL + "\t        \twhile (fetchMore_";
  protected final String TEXT_431 = ") {" + NL + "\t        \t\tresult_";
  protected final String TEXT_432 = " = service_";
  protected final String TEXT_433 = ".execute(executeDoc_";
  protected final String TEXT_434 = ", catd_";
  protected final String TEXT_435 = ", null, null);" + NL + "\t        \t\tcom.microsoft.schemas.crm._2007.webservices.ExecuteResponseDocument.ExecuteResponse executeResponse_";
  protected final String TEXT_436 = " =  result_";
  protected final String TEXT_437 = ".getExecuteResponse();" + NL + "\t           \t\tcom.microsoft.schemas.crm._2007.webservices.Response response_";
  protected final String TEXT_438 = " = executeResponse_";
  protected final String TEXT_439 = ".getResponse();" + NL + "\t        \t\tcom.microsoft.schemas.crm._2007.webservices.RetrieveMultipleResponse rmp_";
  protected final String TEXT_440 = " = (com.microsoft.schemas.crm._2007.webservices.RetrieveMultipleResponse)response_";
  protected final String TEXT_441 = ";" + NL + "\t        \t\tcom.microsoft.schemas.crm._2006.webservices.BusinessEntityCollection bec_";
  protected final String TEXT_442 = " = rmp_";
  protected final String TEXT_443 = ".getBusinessEntityCollection();" + NL + "\t        \t\tString pagingCookie_";
  protected final String TEXT_444 = " = bec_";
  protected final String TEXT_445 = ".getPagingCookie();" + NL + "\t        \t\tfetchMore_";
  protected final String TEXT_446 = " = bec_";
  protected final String TEXT_447 = ".getMoreRecords();" + NL + "\t        \t\tcom.microsoft.schemas.crm._2006.webservices.ArrayOfBusinessEntity aobe_";
  protected final String TEXT_448 = " = bec_";
  protected final String TEXT_449 = ".getBusinessEntities();" + NL + "\t        \t\tcom.microsoft.schemas.crm._2006.webservices.BusinessEntity[] entities_";
  protected final String TEXT_450 = " = aobe_";
  protected final String TEXT_451 = ".getBusinessEntityArray();" + NL + "" + NL + "\t        \t\tfor (int i_";
  protected final String TEXT_452 = " = 0; i_";
  protected final String TEXT_453 = " < entities_";
  protected final String TEXT_454 = ".length; i_";
  protected final String TEXT_455 = "++) {" + NL + "\t                    com.microsoft.schemas.crm._2006.webservices.DynamicEntity dynamicEntity_";
  protected final String TEXT_456 = " = (com.microsoft.schemas.crm._2006.webservices.DynamicEntity)entities_";
  protected final String TEXT_457 = "[i_";
  protected final String TEXT_458 = "];" + NL + "\t                    com.microsoft.schemas.crm._2006.webservices.DynamicEntity.Properties properties_";
  protected final String TEXT_459 = " = dynamicEntity_";
  protected final String TEXT_460 = ".getProperties();" + NL + "\t                    com.microsoft.schemas.crm._2006.webservices.Property[] propertyArray_";
  protected final String TEXT_461 = " = properties_";
  protected final String TEXT_462 = ".getPropertyArray();" + NL + "\t                   \tnb_line_";
  protected final String TEXT_463 = " ++;" + NL + "\t                    String[] propertyValue_";
  protected final String TEXT_464 = " = new String[propertyArray_";
  protected final String TEXT_465 = ".length];" + NL + "\t                    String propertyType_";
  protected final String TEXT_466 = ";" + NL + "\t                    java.util.Map<String,String> propertyMap_";
  protected final String TEXT_467 = " = new java.util.HashMap<String,String>();" + NL + "" + NL + "\t                    for(int j_";
  protected final String TEXT_468 = " = 0; j_";
  protected final String TEXT_469 = " < propertyArray_";
  protected final String TEXT_470 = ".length; j_";
  protected final String TEXT_471 = "++){" + NL + "" + NL + "\t                    \tpropertyType_";
  protected final String TEXT_472 = " = propertyArray_";
  protected final String TEXT_473 = "[j_";
  protected final String TEXT_474 = "].schemaType().getShortJavaName();" + NL + "\t                    \tif(\"CrmBooleanProperty\".equals(propertyType_";
  protected final String TEXT_475 = ")){" + NL + "\t                    \t\tcom.microsoft.schemas.crm._2006.webservices.CrmBooleanProperty tempProperty_";
  protected final String TEXT_476 = " = (com.microsoft.schemas.crm._2006.webservices.CrmBooleanProperty)propertyArray_";
  protected final String TEXT_477 = "[j_";
  protected final String TEXT_478 = "];" + NL + "\t                    \t\tpropertyValue_";
  protected final String TEXT_479 = "[j_";
  protected final String TEXT_480 = "] = tempProperty_";
  protected final String TEXT_481 = ".getValue().getStringValue();" + NL + "\t                    \t\tpropertyMap_";
  protected final String TEXT_482 = ".put(tempProperty_";
  protected final String TEXT_483 = ".getName(),propertyValue_";
  protected final String TEXT_484 = "[j_";
  protected final String TEXT_485 = "]);" + NL + "\t                    \t}else if(\"CrmDateTimeProperty\".equals(propertyType_";
  protected final String TEXT_486 = ")){" + NL + "\t                    \t\tcom.microsoft.schemas.crm._2006.webservices.CrmDateTimeProperty tempProperty_";
  protected final String TEXT_487 = " = (com.microsoft.schemas.crm._2006.webservices.CrmDateTimeProperty)propertyArray_";
  protected final String TEXT_488 = "[j_";
  protected final String TEXT_489 = "];" + NL + "\t\t\t\t\t\t\t\tString tempDateString_";
  protected final String TEXT_490 = " = tempProperty_";
  protected final String TEXT_491 = ".getValue().getStringValue();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_492 = NL + "\t\t\t\t\t\t\t\ttempDateString_";
  protected final String TEXT_493 = " = tempDateString_";
  protected final String TEXT_494 = ".substring(0, tempDateString_";
  protected final String TEXT_495 = ".lastIndexOf(\":\")) + tempDateString_";
  protected final String TEXT_496 = ".substring(tempDateString_";
  protected final String TEXT_497 = ".lastIndexOf(\":\") + 1);" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_498 = "[j_";
  protected final String TEXT_499 = "] = tempDateString_";
  protected final String TEXT_500 = ";" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_501 = ".put(tempProperty_";
  protected final String TEXT_502 = ".getName(),propertyValue_";
  protected final String TEXT_503 = "[j_";
  protected final String TEXT_504 = "]);" + NL + "\t                    \t}else if(\"CrmDecimalProperty\".equals(propertyType_";
  protected final String TEXT_505 = ")){" + NL + "\t                    \t\tcom.microsoft.schemas.crm._2006.webservices.CrmDecimalProperty tempProperty_";
  protected final String TEXT_506 = " = (com.microsoft.schemas.crm._2006.webservices.CrmDecimalProperty)propertyArray_";
  protected final String TEXT_507 = "[j_";
  protected final String TEXT_508 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_509 = "[j_";
  protected final String TEXT_510 = "] = tempProperty_";
  protected final String TEXT_511 = ".getValue().getStringValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_512 = ".put(tempProperty_";
  protected final String TEXT_513 = ".getName(),propertyValue_";
  protected final String TEXT_514 = "[j_";
  protected final String TEXT_515 = "]);" + NL + "\t                    \t}else if(\"CrmFloatProperty\".equals(propertyType_";
  protected final String TEXT_516 = ")){" + NL + "\t                    \t\tcom.microsoft.schemas.crm._2006.webservices.CrmFloatProperty tempProperty_";
  protected final String TEXT_517 = " = (com.microsoft.schemas.crm._2006.webservices.CrmFloatProperty)propertyArray_";
  protected final String TEXT_518 = "[j_";
  protected final String TEXT_519 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_520 = "[j_";
  protected final String TEXT_521 = "] = tempProperty_";
  protected final String TEXT_522 = ".getValue().getStringValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_523 = ".put(tempProperty_";
  protected final String TEXT_524 = ".getName(),propertyValue_";
  protected final String TEXT_525 = "[j_";
  protected final String TEXT_526 = "]);" + NL + "\t                    \t}else if(\"CrmMoneyProperty\".equals(propertyType_";
  protected final String TEXT_527 = ")){" + NL + "\t                    \t\tcom.microsoft.schemas.crm._2006.webservices.CrmMoneyProperty tempProperty_";
  protected final String TEXT_528 = " = (com.microsoft.schemas.crm._2006.webservices.CrmMoneyProperty)propertyArray_";
  protected final String TEXT_529 = "[j_";
  protected final String TEXT_530 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_531 = "[j_";
  protected final String TEXT_532 = "] = tempProperty_";
  protected final String TEXT_533 = ".getValue().getStringValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_534 = ".put(tempProperty_";
  protected final String TEXT_535 = ".getName(),propertyValue_";
  protected final String TEXT_536 = "[j_";
  protected final String TEXT_537 = "]);" + NL + "\t\t\t\t\t\t\t}else if(\"CrmNumberProperty\".equals(propertyType_";
  protected final String TEXT_538 = ")){" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2006.webservices.CrmNumberProperty tempProperty_";
  protected final String TEXT_539 = " = (com.microsoft.schemas.crm._2006.webservices.CrmNumberProperty)propertyArray_";
  protected final String TEXT_540 = "[j_";
  protected final String TEXT_541 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_542 = "[j_";
  protected final String TEXT_543 = "] = tempProperty_";
  protected final String TEXT_544 = ".getValue().getStringValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_545 = ".put(tempProperty_";
  protected final String TEXT_546 = ".getName(),propertyValue_";
  protected final String TEXT_547 = "[j_";
  protected final String TEXT_548 = "]);" + NL + "\t\t\t\t\t\t\t}else if(\"CustomerProperty\".equals(propertyType_";
  protected final String TEXT_549 = ")){" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2006.webservices.CustomerProperty tempProperty_";
  protected final String TEXT_550 = " = (com.microsoft.schemas.crm._2006.webservices.CustomerProperty)propertyArray_";
  protected final String TEXT_551 = "[j_";
  protected final String TEXT_552 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_553 = "[j_";
  protected final String TEXT_554 = "] = tempProperty_";
  protected final String TEXT_555 = ".getValue().getStringValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_556 = ".put(tempProperty_";
  protected final String TEXT_557 = ".getName(),propertyValue_";
  protected final String TEXT_558 = "[j_";
  protected final String TEXT_559 = "]);" + NL + "\t\t\t\t\t\t\t}else if(\"KeyProperty\".equals(propertyType_";
  protected final String TEXT_560 = ")){" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2006.webservices.KeyProperty tempProperty_";
  protected final String TEXT_561 = " = (com.microsoft.schemas.crm._2006.webservices.KeyProperty)propertyArray_";
  protected final String TEXT_562 = "[j_";
  protected final String TEXT_563 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_564 = "[j_";
  protected final String TEXT_565 = "] = tempProperty_";
  protected final String TEXT_566 = ".getValue().getStringValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_567 = ".put(tempProperty_";
  protected final String TEXT_568 = ".getName(),propertyValue_";
  protected final String TEXT_569 = "[j_";
  protected final String TEXT_570 = "]);" + NL + "\t\t\t\t\t\t\t}else if(\"LookupProperty\".equals(propertyType_";
  protected final String TEXT_571 = ")){" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2006.webservices.LookupProperty tempProperty_";
  protected final String TEXT_572 = " = (com.microsoft.schemas.crm._2006.webservices.LookupProperty)propertyArray_";
  protected final String TEXT_573 = "[j_";
  protected final String TEXT_574 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_575 = "[j_";
  protected final String TEXT_576 = "] = tempProperty_";
  protected final String TEXT_577 = ".getValue().getStringValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_578 = ".put(tempProperty_";
  protected final String TEXT_579 = ".getName(),propertyValue_";
  protected final String TEXT_580 = "[j_";
  protected final String TEXT_581 = "]);" + NL + "\t\t\t\t\t\t\t}else if(\"OwnerProperty\".equals(propertyType_";
  protected final String TEXT_582 = ")){" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2006.webservices.OwnerProperty tempProperty_";
  protected final String TEXT_583 = " = (com.microsoft.schemas.crm._2006.webservices.OwnerProperty)propertyArray_";
  protected final String TEXT_584 = "[j_";
  protected final String TEXT_585 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_586 = "[j_";
  protected final String TEXT_587 = "] = tempProperty_";
  protected final String TEXT_588 = ".getValue().getStringValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_589 = ".put(tempProperty_";
  protected final String TEXT_590 = ".getName(),propertyValue_";
  protected final String TEXT_591 = "[j_";
  protected final String TEXT_592 = "]);" + NL + "\t\t\t\t\t\t\t}else if(\"PicklistProperty\".equals(propertyType_";
  protected final String TEXT_593 = ")){" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2006.webservices.PicklistProperty tempProperty_";
  protected final String TEXT_594 = " = (com.microsoft.schemas.crm._2006.webservices.PicklistProperty)propertyArray_";
  protected final String TEXT_595 = "[j_";
  protected final String TEXT_596 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_597 = "[j_";
  protected final String TEXT_598 = "] = tempProperty_";
  protected final String TEXT_599 = ".getValue().getStringValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_600 = ".put(tempProperty_";
  protected final String TEXT_601 = ".getName(),propertyValue_";
  protected final String TEXT_602 = "[j_";
  protected final String TEXT_603 = "]);" + NL + "\t\t\t\t\t\t\t}else if(\"StateProperty\".equals(propertyType_";
  protected final String TEXT_604 = ")){" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2006.webservices.StateProperty tempProperty_";
  protected final String TEXT_605 = " = (com.microsoft.schemas.crm._2006.webservices.StateProperty)propertyArray_";
  protected final String TEXT_606 = "[j_";
  protected final String TEXT_607 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_608 = "[j_";
  protected final String TEXT_609 = "] = tempProperty_";
  protected final String TEXT_610 = ".getValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_611 = ".put(tempProperty_";
  protected final String TEXT_612 = ".getName(),propertyValue_";
  protected final String TEXT_613 = "[j_";
  protected final String TEXT_614 = "]);" + NL + "\t\t\t\t\t\t\t}else if(\"StatusProperty\".equals(propertyType_";
  protected final String TEXT_615 = ")){" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2006.webservices.StatusProperty tempProperty_";
  protected final String TEXT_616 = " = (com.microsoft.schemas.crm._2006.webservices.StatusProperty)propertyArray_";
  protected final String TEXT_617 = "[j_";
  protected final String TEXT_618 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_619 = "[j_";
  protected final String TEXT_620 = "] = tempProperty_";
  protected final String TEXT_621 = ".getValue().getStringValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_622 = ".put(tempProperty_";
  protected final String TEXT_623 = ".getName(),propertyValue_";
  protected final String TEXT_624 = "[j_";
  protected final String TEXT_625 = "]);" + NL + "\t\t\t\t\t\t\t}else if(\"StringProperty\".equals(propertyType_";
  protected final String TEXT_626 = ")){" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2006.webservices.StringProperty tempProperty_";
  protected final String TEXT_627 = " = (com.microsoft.schemas.crm._2006.webservices.StringProperty)propertyArray_";
  protected final String TEXT_628 = "[j_";
  protected final String TEXT_629 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_630 = "[j_";
  protected final String TEXT_631 = "] = tempProperty_";
  protected final String TEXT_632 = ".getValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_633 = ".put(tempProperty_";
  protected final String TEXT_634 = ".getName(),propertyValue_";
  protected final String TEXT_635 = "[j_";
  protected final String TEXT_636 = "]);" + NL + "\t\t\t\t\t\t\t}else if(\"UniqueIdentifierProperty\".equals(propertyType_";
  protected final String TEXT_637 = ")){" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2006.webservices.UniqueIdentifierProperty tempProperty_";
  protected final String TEXT_638 = " = (com.microsoft.schemas.crm._2006.webservices.UniqueIdentifierProperty)propertyArray_";
  protected final String TEXT_639 = "[j_";
  protected final String TEXT_640 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_641 = "[j_";
  protected final String TEXT_642 = "] = tempProperty_";
  protected final String TEXT_643 = ".getValue().getStringValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_644 = ".put(tempProperty_";
  protected final String TEXT_645 = ".getName(),propertyValue_";
  protected final String TEXT_646 = "[j_";
  protected final String TEXT_647 = "]);" + NL + "\t\t\t\t\t\t\t}" + NL + "\t                    }" + NL + "\t                   \t\t";
  protected final String TEXT_648 = NL + NL + "\t\t\t\t\t\t\t\tif(propertyMap_";
  protected final String TEXT_649 = ".get(\"";
  protected final String TEXT_650 = "\")!=null){" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_651 = NL + "\t        \t\t\t\t\t\t\t";
  protected final String TEXT_652 = ".";
  protected final String TEXT_653 = " = propertyMap_";
  protected final String TEXT_654 = ".get(\"";
  protected final String TEXT_655 = "\");" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_656 = NL + "\t        \t\t\t\t\t\t\t";
  protected final String TEXT_657 = ".";
  protected final String TEXT_658 = " = ParserUtils.parseTo_Date(propertyMap_";
  protected final String TEXT_659 = ".get(\"";
  protected final String TEXT_660 = "\"), ";
  protected final String TEXT_661 = ");" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_662 = NL + "\t        \t\t\t\t\t\t\t";
  protected final String TEXT_663 = ".";
  protected final String TEXT_664 = " = ParserUtils.parseTo_Double(propertyMap_";
  protected final String TEXT_665 = ".get(\"";
  protected final String TEXT_666 = "\"));" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_667 = NL + "\t        \t\t\t\t\t\t\t";
  protected final String TEXT_668 = ".";
  protected final String TEXT_669 = " = ParserUtils.parseTo_BigDecimal(propertyMap_";
  protected final String TEXT_670 = ".get(\"";
  protected final String TEXT_671 = "\"));" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_672 = NL + "\t        \t\t\t\t\t\t\t";
  protected final String TEXT_673 = ".";
  protected final String TEXT_674 = " = ParserUtils.parseTo_Float(propertyMap_";
  protected final String TEXT_675 = ".get(\"";
  protected final String TEXT_676 = "\"));" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_677 = NL + "\t        \t\t\t\t\t\t\t";
  protected final String TEXT_678 = ".";
  protected final String TEXT_679 = " = ParserUtils.parseTo_Integer(propertyMap_";
  protected final String TEXT_680 = ".get(\"";
  protected final String TEXT_681 = "\"));" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_682 = NL + "\t        \t\t\t\t\t\t\t";
  protected final String TEXT_683 = ".";
  protected final String TEXT_684 = " = ParserUtils.parseTo_Boolean(propertyMap_";
  protected final String TEXT_685 = ".get(\"";
  protected final String TEXT_686 = "\"));" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_687 = NL + "\t        \t\t\t\t\t\t\t";
  protected final String TEXT_688 = ".";
  protected final String TEXT_689 = " = propertyMap_";
  protected final String TEXT_690 = ".get(\"";
  protected final String TEXT_691 = "\");" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_692 = NL + "\t        \t\t\t\t\t\t\t";
  protected final String TEXT_693 = ".";
  protected final String TEXT_694 = " = ParserUtils.parseTo_";
  protected final String TEXT_695 = "(propertyMap_";
  protected final String TEXT_696 = ".get(\"";
  protected final String TEXT_697 = "\"));" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_698 = NL + "\t        \t\t\t\t\t}else{" + NL + "\t        \t\t\t\t\t\t";
  protected final String TEXT_699 = ".";
  protected final String TEXT_700 = " = ";
  protected final String TEXT_701 = ";" + NL + "\t        \t\t\t\t\t}" + NL + "\t        \t\t\t\t";
  protected final String TEXT_702 = NL + NL + NL + "\t\t\t\t";
  protected final String TEXT_703 = NL + "\t\t\t\torg.talend.ms.crm.MSCRMClient client_";
  protected final String TEXT_704 = " = new org.talend.ms.crm.MSCRMClient(";
  protected final String TEXT_705 = ", decryptedPassword_";
  protected final String TEXT_706 = ", ";
  protected final String TEXT_707 = ");" + NL + "\t\t\t\tclient_";
  protected final String TEXT_708 = ".setTimeout(";
  protected final String TEXT_709 = ");" + NL + "\t\t\t\tclient_";
  protected final String TEXT_710 = ".setReuseHttpClient(";
  protected final String TEXT_711 = ");" + NL + "\t\t\t\tclient_";
  protected final String TEXT_712 = ".setMaxConnectionRetries(reConnMaxNum_";
  protected final String TEXT_713 = ");" + NL + "\t\t\t\tclient_";
  protected final String TEXT_714 = ".setAttemptsInterval(";
  protected final String TEXT_715 = ");" + NL + "\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.OrganizationServiceStub serviceStub_";
  protected final String TEXT_716 = " = client_";
  protected final String TEXT_717 = ".getOnlineConnection(";
  protected final String TEXT_718 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_719 = NL + "\t        \tcom.microsoft.schemas.xrm._2011.contracts.QueryExpression query_";
  protected final String TEXT_720 = " = com.microsoft.schemas.xrm._2011.contracts.QueryExpression.Factory.newInstance();" + NL + "\t        \tcom.microsoft.schemas.xrm._2011.contracts.ColumnSet cols_";
  protected final String TEXT_721 = " = com.microsoft.schemas.xrm._2011.contracts.ColumnSet.Factory.newInstance();" + NL + "\t        \tcom.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring aos_";
  protected final String TEXT_722 = " = com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring.Factory.newInstance();" + NL + "\t       \t\t";
  protected final String TEXT_723 = NL + "\t        \t\tcom.microsoft.schemas.xrm._2011.contracts.ArrayOfConditionExpression conditions_";
  protected final String TEXT_724 = " = com.microsoft.schemas.xrm._2011.contracts.ArrayOfConditionExpression.Factory.newInstance();" + NL + "\t        \t\tcom.microsoft.schemas.xrm._2011.contracts.ConditionExpression condition_";
  protected final String TEXT_725 = " = null;" + NL + "\t        \t\tcom.microsoft.schemas._2003._10.serialization.arrays.ArrayOfanyType values_";
  protected final String TEXT_726 = " = null;" + NL + "\t        \t\torg.apache.xmlbeans.XmlString conditionValue_";
  protected final String TEXT_727 = " = null;" + NL + "\t            \t";
  protected final String TEXT_728 = NL + "\t\t            \t\tcondition_";
  protected final String TEXT_729 = " = conditions_";
  protected final String TEXT_730 = ".addNewConditionExpression();" + NL + "\t\t            \t\tcondition_";
  protected final String TEXT_731 = ".setAttributeName(\"";
  protected final String TEXT_732 = "\");" + NL + "\t\t            \t\tcondition_";
  protected final String TEXT_733 = ".setOperator(com.microsoft.schemas.xrm._2011.contracts.ConditionOperator.Enum.forString(\"";
  protected final String TEXT_734 = "\"));" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_735 = NL + "\t            \t\t\tvalues_";
  protected final String TEXT_736 = " = com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfanyType.Factory.newInstance();" + NL + "\t            \t\t\tconditionValue_";
  protected final String TEXT_737 = " = org.apache.xmlbeans.XmlString.Factory.newInstance();" + NL + "\t            \t\t\tconditionValue_";
  protected final String TEXT_738 = ".setStringValue(";
  protected final String TEXT_739 = ");" + NL + "\t            \t\t\tvalues_";
  protected final String TEXT_740 = ".setAnyTypeArray(new org.apache.xmlbeans.XmlString[]{conditionValue_";
  protected final String TEXT_741 = "});" + NL + "\t            \t\t\tcondition_";
  protected final String TEXT_742 = ".setValues(values_";
  protected final String TEXT_743 = ");" + NL + "\t       \t\t\t\t";
  protected final String TEXT_744 = NL + "\t        \t\t";
  protected final String TEXT_745 = NL + "\t        \t\t\tcom.microsoft.schemas.xrm._2011.contracts.FilterExpression filter_";
  protected final String TEXT_746 = " = com.microsoft.schemas.xrm._2011.contracts.FilterExpression.Factory.newInstance();" + NL + "\t        \t\t\tfilter_";
  protected final String TEXT_747 = ".setFilterOperator(com.microsoft.schemas.xrm._2011.contracts.LogicalOperator.Enum.forString(\"";
  protected final String TEXT_748 = "\"));" + NL + "\t        \t\t\tfilter_";
  protected final String TEXT_749 = ".setConditions(conditions_";
  protected final String TEXT_750 = ");" + NL + "\t        \t\t\tquery_";
  protected final String TEXT_751 = ".setCriteria(filter_";
  protected final String TEXT_752 = ");" + NL + "\t       \t\t\t";
  protected final String TEXT_753 = NL + NL + "\t        \t";
  protected final String TEXT_754 = NL + "\t        \taos_";
  protected final String TEXT_755 = ".setStringArray(new String[]{";
  protected final String TEXT_756 = "});" + NL + "\t        \tcols_";
  protected final String TEXT_757 = ".setColumns(aos_";
  protected final String TEXT_758 = ");" + NL + "\t        \tquery_";
  protected final String TEXT_759 = ".setColumnSet(cols_";
  protected final String TEXT_760 = ");" + NL + "\t        \tquery_";
  protected final String TEXT_761 = ".setEntityName(\"";
  protected final String TEXT_762 = "\");" + NL + "" + NL + "\t        \tcom.microsoft.schemas.xrm._2011.contracts.PagingInfo pagingInfo_";
  protected final String TEXT_763 = " = com.microsoft.schemas.xrm._2011.contracts.PagingInfo.Factory.newInstance();" + NL + "\t        \tint pageNumber_";
  protected final String TEXT_764 = " = 1;" + NL + "\t        \tpagingInfo_";
  protected final String TEXT_765 = ".setPageNumber(pageNumber_";
  protected final String TEXT_766 = ");" + NL + "\t        \t";
  protected final String TEXT_767 = NL + "\t        \tpagingInfo_";
  protected final String TEXT_768 = ".setCount(5);" + NL + "\t        \t";
  protected final String TEXT_769 = NL + "\t        \tquery_";
  protected final String TEXT_770 = ".setPageInfo(pagingInfo_";
  protected final String TEXT_771 = ");" + NL + "" + NL + "\t        \tcom.microsoft.schemas.xrm._2011.contracts.services.RetrieveMultipleDocument.RetrieveMultiple rmr_";
  protected final String TEXT_772 = " = com.microsoft.schemas.xrm._2011.contracts.services.RetrieveMultipleDocument.RetrieveMultiple.Factory.newInstance();" + NL + "\t        \tcom.microsoft.schemas.xrm._2011.contracts.services.RetrieveMultipleResponseDocument.RetrieveMultipleResponse retrieveMultipleResp_";
  protected final String TEXT_773 = " = null;" + NL + "\t        \twhile(true){" + NL + "\t        \t\trmr_";
  protected final String TEXT_774 = ".setQuery(query_";
  protected final String TEXT_775 = ");" + NL + "\t        \t\tcom.microsoft.schemas.xrm._2011.contracts.services.RetrieveMultipleDocument rmrdoc_";
  protected final String TEXT_776 = " = com.microsoft.schemas.xrm._2011.contracts.services.RetrieveMultipleDocument.Factory.newInstance();" + NL + "\t        \t\trmrdoc_";
  protected final String TEXT_777 = ".setRetrieveMultiple(rmr_";
  protected final String TEXT_778 = ");" + NL + "\t        \t\ttry{" + NL + "\t        \t\t\tretrieveMultipleResp_";
  protected final String TEXT_779 = " = serviceStub_";
  protected final String TEXT_780 = ".retrieveMultiple(rmrdoc_";
  protected final String TEXT_781 = ").getRetrieveMultipleResponse();" + NL + "\t        \t\t}catch(com.microsoft.schemas.xrm._2011.contracts.IOrganizationService_RetrieveMultiple_OrganizationServiceFaultFault_FaultMessage ex_";
  protected final String TEXT_782 = "){" + NL + "\t        \t\t\tthrow new Exception(ex_";
  protected final String TEXT_783 = ".getFaultMessage().getOrganizationServiceFault().getMessage());" + NL + "\t        \t\t}" + NL + "\t        \t\tcom.microsoft.schemas.xrm._2011.contracts.EntityCollection retrieveMultipleResult_";
  protected final String TEXT_784 = " = retrieveMultipleResp_";
  protected final String TEXT_785 = ".getRetrieveMultipleResult();" + NL + "\t        \t\tcom.microsoft.schemas.xrm._2011.contracts.Entity[] entities_";
  protected final String TEXT_786 = " = retrieveMultipleResult_";
  protected final String TEXT_787 = ".getEntities().getEntityArray();" + NL + "\t        \t\tfor(com.microsoft.schemas.xrm._2011.contracts.Entity entity_";
  protected final String TEXT_788 = " : entities_";
  protected final String TEXT_789 = "){" + NL + "\t                   \tnb_line_";
  protected final String TEXT_790 = "++;" + NL + "\t                    org.datacontract.schemas._2004._07.system_collections_generic.KeyValuePairOfstringanyType[] properties_";
  protected final String TEXT_791 = " = entity_";
  protected final String TEXT_792 = ".getAttributes().getKeyValuePairOfstringanyTypeArray();" + NL + "" + NL + "\t                    java.util.Map<String, String> propertyMap_";
  protected final String TEXT_793 = " = new java.util.HashMap<String, String>();" + NL + "\t                    String propertyValue_";
  protected final String TEXT_794 = " = null;" + NL + "\t                    org.apache.xmlbeans.XmlObject tempPropertyValue_";
  protected final String TEXT_795 = " = null;" + NL + "\t                    for(org.datacontract.schemas._2004._07.system_collections_generic.KeyValuePairOfstringanyType property_";
  protected final String TEXT_796 = " : properties_";
  protected final String TEXT_797 = "){" + NL + "\t                    \ttempPropertyValue_";
  protected final String TEXT_798 = " = property_";
  protected final String TEXT_799 = ".getValue();" + NL + "\t                    \tif(tempPropertyValue_";
  protected final String TEXT_800 = " instanceof org.apache.xmlbeans.XmlAnySimpleType){" + NL + "\t                    \t\tpropertyValue_";
  protected final String TEXT_801 = " = ((org.apache.xmlbeans.XmlAnySimpleType)tempPropertyValue_";
  protected final String TEXT_802 = ").getStringValue();" + NL + "\t                    \t}else if(tempPropertyValue_";
  protected final String TEXT_803 = " instanceof com.microsoft.schemas.xrm._2011.contracts.OptionSetValue){" + NL + "\t                    \t\tpropertyValue_";
  protected final String TEXT_804 = " = ((com.microsoft.schemas.xrm._2011.contracts.OptionSetValue)tempPropertyValue_";
  protected final String TEXT_805 = ").xgetValue().getStringValue();" + NL + "\t                    \t}else if(tempPropertyValue_";
  protected final String TEXT_806 = " instanceof com.microsoft.schemas.xrm._2011.contracts.Money){" + NL + "\t                    \t\tpropertyValue_";
  protected final String TEXT_807 = " = ((com.microsoft.schemas.xrm._2011.contracts.Money)tempPropertyValue_";
  protected final String TEXT_808 = ").xgetValue().getStringValue();" + NL + "\t                    \t}else if(tempPropertyValue_";
  protected final String TEXT_809 = " instanceof com.microsoft.schemas.xrm._2011.contracts.EntityReference){" + NL + "\t                    \t\tcom.microsoft.schemas.xrm._2011.contracts.EntityReference entityReference_";
  protected final String TEXT_810 = " = (com.microsoft.schemas.xrm._2011.contracts.EntityReference)tempPropertyValue_";
  protected final String TEXT_811 = ";" + NL + "                        \t\tpropertyValue_";
  protected final String TEXT_812 = " = \"{\\\"id\\\":\\\"\"+entityReference_";
  protected final String TEXT_813 = ".getId() + \"\\\",\\\"logicalName\\\":\\\"\" + entityReference_";
  protected final String TEXT_814 = ".getLogicalName() + \"\\\",\\\"name\\\":\\\"\" + entityReference_";
  protected final String TEXT_815 = ".getName() + \"\\\"}\";" + NL + "\t                    \t}else if(tempPropertyValue_";
  protected final String TEXT_816 = " instanceof com.microsoft.schemas.xrm._2011.contracts.BooleanManagedProperty){" + NL + "\t                    \t\tcom.microsoft.schemas.xrm._2011.contracts.BooleanManagedProperty booleanManagedProperty_";
  protected final String TEXT_817 = " = (com.microsoft.schemas.xrm._2011.contracts.BooleanManagedProperty)tempPropertyValue_";
  protected final String TEXT_818 = ";" + NL + "\t                    \t\tpropertyValue_";
  protected final String TEXT_819 = " = \"{\\\"canBeChanged\\\":\\\"\"+booleanManagedProperty_";
  protected final String TEXT_820 = ".getCanBeChanged() + \"\\\",\\\"logicalName\\\":\\\"\" + booleanManagedProperty_";
  protected final String TEXT_821 = ".getManagedPropertyLogicalName() + \"\\\",\\\"value\\\":\\\"\" + booleanManagedProperty_";
  protected final String TEXT_822 = ".getValue() + \"\\\"}\";" + NL + "\t                    \t}else{" + NL + "\t                    \t\tSystem.err.println(\"don't support the type of \" + property_";
  protected final String TEXT_823 = ");" + NL + "\t                    \t\tpropertyValue_";
  protected final String TEXT_824 = " = null;" + NL + "\t                    \t}" + NL + "                    \t\tpropertyMap_";
  protected final String TEXT_825 = ".put(property_";
  protected final String TEXT_826 = ".getKey(), propertyValue_";
  protected final String TEXT_827 = ");" + NL + "\t                    }" + NL + "                   \t\t";
  protected final String TEXT_828 = NL + NL + "\t\t\t\t\t\t\tif(propertyMap_";
  protected final String TEXT_829 = ".get(\"";
  protected final String TEXT_830 = "\")!=null){" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_831 = NL + "\t        \t\t\t\t\t\t";
  protected final String TEXT_832 = ".";
  protected final String TEXT_833 = " = propertyMap_";
  protected final String TEXT_834 = ".get(\"";
  protected final String TEXT_835 = "\");" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_836 = NL + "\t        \t\t\t\t\t\t";
  protected final String TEXT_837 = ".";
  protected final String TEXT_838 = " = ParserUtils.parseTo_Date(propertyMap_";
  protected final String TEXT_839 = ".get(\"";
  protected final String TEXT_840 = "\"), ";
  protected final String TEXT_841 = ");" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_842 = NL + "\t        \t\t\t\t\t\t";
  protected final String TEXT_843 = ".";
  protected final String TEXT_844 = " = ParserUtils.parseTo_";
  protected final String TEXT_845 = "(propertyMap_";
  protected final String TEXT_846 = ".get(\"";
  protected final String TEXT_847 = "\"));" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_848 = NL + "        \t\t\t\t\t}else{" + NL + "        \t\t\t\t\t\t";
  protected final String TEXT_849 = ".";
  protected final String TEXT_850 = " = ";
  protected final String TEXT_851 = ";" + NL + "        \t\t\t\t\t}" + NL + "        \t\t\t\t";
  protected final String TEXT_852 = NL + "\t\t\t\t";
  protected final String TEXT_853 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

    String authenticationType = ElementParameterParser.getValue(node, "__AUTH_TYPE__");
    String crmVersion = ElementParameterParser.getValue(node, "__MS_CRM_VERSION__");

    boolean isMsCrm2015OnPremise = "ON_PREMISE".equals(authenticationType) && "CRM_2015".equals(crmVersion);
    
    String attemptConnTimes = ElementParameterParser.getValue(node, "__MAX_RECONN_ATTEMPS__");
	String attemptsInterval = ElementParameterParser.getValue(node, "__ATTEMPS_INTERVAL_TIME__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(attemptConnTimes);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
    if(isMsCrm2015OnPremise){
       
    stringBuffer.append(TEXT_9);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_10);
    
   List<IMetadataTable> metadataTableList = node.getMetadataList();
   if((metadataTableList != null) && (metadataTableList.size() > 0)){
        IMetadataTable metadata = metadataTableList.get(0);
        if(metadata != null){
            List<IMetadataColumn> columnList = metadata.getListColumns();
            int columnSize = columnList.size();
            //Concatenate schemas as string
            String schemasAsString = null;
            StringBuilder strBuilder4Schema = new StringBuilder();
            for(int i = 0; i < columnSize; i++){
                if(i > 0){
                    strBuilder4Schema.append(", ");
                }
                   strBuilder4Schema.append("\"");
                   strBuilder4Schema.append(columnList.get(i).getLabel());
                   strBuilder4Schema.append("\"");
            }
            schemasAsString = strBuilder4Schema.toString();

            List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
            if(columnSize > 0 && outgoingConns != null && outgoingConns.size() > 0){
                 String domainUserName =  ElementParameterParser.getValue(node, "__USERNAME__");
                 String passwordFieldName = "__PASSWORD__";
                 
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_13);
    } else {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_16);
    }
    
                 String timeout = ElementParameterParser.getValue(node, "__TIMEOUT__");
                 int timeoutInSeconds = Integer.valueOf((timeout != null && !"".equals(timeout)) ? timeout : "1").intValue() * 1000;

                 String organizationWsdl = ElementParameterParser.getValue(node, "__ORGANIZATION_WSDL__");
                 String securityServiceWsdl = ElementParameterParser.getValue(node, "__SECURITY_SERVICE_URL__");
                 String certificatePath = ElementParameterParser.getValue(node, "__CERTIFICATE_PATH__");
                 if(certificatePath != null && !"".equals(certificatePath) && !"\"\"".equals(certificatePath)){
                 
    stringBuffer.append(TEXT_17);
    stringBuffer.append( certificatePath );
    stringBuffer.append(TEXT_18);
    
                 }
                 
    stringBuffer.append(TEXT_19);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(TEXT_21);
    stringBuffer.append( organizationWsdl );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( securityServiceWsdl );
    stringBuffer.append(TEXT_23);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(TEXT_25);
    stringBuffer.append( domainUserName );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_30);
    
                   String entityname = ElementParameterParser.getValue(node, "__ENTITYNAME__").trim();
                   String customEntityname = ElementParameterParser.getValue(node, "__CUSTOM_ENTITY_NAME__");
                   if("CustomEntity".equals(entityname)){
                       entityname = customEntityname.replaceAll("\"","");
                   }
                       entityname = entityname.toLowerCase();
                   //Logical Operator for FilterExpression
                   String logicalOperator = ElementParameterParser.getValue(node,"__LOGICAL_OP__");
                   //Logical Operator for ConditionExpression
                   List<Map<String, String>> keyColumns = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__CONDITIONS__");
                 
    stringBuffer.append(TEXT_31);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_34);
    
                //Use Query Criteria
                if(keyColumns.size()>0){
                    
    stringBuffer.append(TEXT_35);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_37);
    
                    StringBuilder strBuilder = new StringBuilder("");
                    int conditionIndex = 0;
                    for(Map<String, String> keyColumn: keyColumns){
                        String conditionId = cid + "_" + String.valueOf(conditionIndex);
                        
    stringBuffer.append(TEXT_38);
    stringBuffer.append( conditionId );
    stringBuffer.append(TEXT_39);
    stringBuffer.append( conditionId );
    stringBuffer.append(TEXT_40);
    stringBuffer.append( keyColumn.get("INPUT_COLUMN") );
    stringBuffer.append(TEXT_41);
    stringBuffer.append( conditionId );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(keyColumn.get("OPERATOR"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append( conditionId );
    stringBuffer.append(TEXT_44);
    stringBuffer.append( conditionId );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(keyColumn.get("RVALUE"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append( conditionId );
    stringBuffer.append(TEXT_47);
    stringBuffer.append( conditionId );
    stringBuffer.append(TEXT_48);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append( conditionId );
    stringBuffer.append(TEXT_50);
    
                        conditionIndex ++;
                    }
                        
    stringBuffer.append(TEXT_51);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append( logicalOperator );
    stringBuffer.append(TEXT_55);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_57);
    
                }
                
    stringBuffer.append(TEXT_58);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append( schemasAsString );
    stringBuffer.append(TEXT_60);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append( entityname );
    stringBuffer.append(TEXT_66);
    
                //Begin to Transfer Data
                IConnection outgoingConn = outgoingConns.get(0);
                if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
                
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_90);
    
                                for(int i = 0; i < columnList.size(); i++){
                                    IMetadataColumn column = columnList.get(i);
                                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                                    JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                                    String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                                    
    stringBuffer.append(TEXT_91);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_93);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_97);
    
                                        if(javaType == JavaTypesManager.STRING){
                                        
    stringBuffer.append(TEXT_98);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_99);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_100);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_101);
    
                                        }else if(javaType == JavaTypesManager.OBJECT){
                                        
    stringBuffer.append(TEXT_102);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_103);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_104);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_106);
    
                                        }
                                        else if(javaType == JavaTypesManager.DATE){
                                        
    stringBuffer.append(TEXT_107);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_110);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_111);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_114);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_115);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_117);
    
                                        }else if(javaType == JavaTypesManager.INTEGER){
                                         
    stringBuffer.append(TEXT_118);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_122);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_125);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_126);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_127);
    
                                        }else if(javaType == JavaTypesManager.BIGDECIMAL){
                                        
    stringBuffer.append(TEXT_128);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_131);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_132);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_136);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_137);
    
                                        }else{
                                        
    stringBuffer.append(TEXT_138);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_139);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_140);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_141);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_142);
    
                                        }
                                        
    stringBuffer.append(TEXT_143);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_145);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_147);
    
                                }
                            
     //}// Entity For Loop end but moved to the end part 
    
                }
            }
        }
    }
 
    
    }else{
    	  String crmOnlineVersion = ElementParameterParser.getValue(node, "__API_VERSION__");
    	  boolean isOnline2016WithOdata="ONLINE".equals(authenticationType) && "API_2016_ODATA".equals(crmOnlineVersion);
    	  boolean isMsCrm2016OnPremise = "ON_PREMISE".equals(authenticationType) && "CRM_2016".equals(crmVersion);
    	  if(isOnline2016WithOdata || isMsCrm2016OnPremise){
    	  
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {
	IMetadataTable metadata = metadatas.get(0);

	if (metadata != null) {
		List<IMetadataColumn> columnList = metadata.getListColumns();
		int nbSchemaColumns = columnList.size();
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();

		// if output columns are defined
		if(nbSchemaColumns > 0 && outgoingConns != null && outgoingConns.size() > 0){
		    
		    String authType = ElementParameterParser.getValue(node, "__AUTH_TYPE__");
			String userName = ElementParameterParser.getValue(node, "__USERNAME__");
			String domain = ElementParameterParser.getValue(node, "__DOMAIN__");
            String host = ElementParameterParser.getValue(node, "__HOST__");
			String serviceURL = ElementParameterParser.getValue(node, "__SERVICE_ROOT_URL__");
			String applicationId = ElementParameterParser.getValue(node, "__APPLICATION_ID__");
			String authority = ElementParameterParser.getValue(node, "__AUTHORITY__");
			String timeout = ElementParameterParser.getValue(node, "__TIMEOUT__");
			boolean reuseHttpClient = ("true").equals(ElementParameterParser.getValue(node,"__REUSE_HTTP_CLIENT__"));
			// TODO Because of current retrieve would close httpclient automatically
        	// Need to recreated httpclient for every page query
			reuseHttpClient =false;
			
			String passwordFieldName = "__PASSWORD__";
			String entitySetName = ElementParameterParser.getValue(node, "__ENTITYSET__").trim();
     		String customEntityname = ElementParameterParser.getValue(node, "__CUSTOM_ENTITY_NAME__");
     		if("CustomEntitySet".equals(entitySetName)){
			
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(customEntityname);
    stringBuffer.append(TEXT_150);
    
			}else{
			
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(entitySetName);
    stringBuffer.append(TEXT_153);
    	
			}
			boolean debug = ("true").equals(ElementParameterParser.getValue(node,"__DEBUG__"));
			if(debug){
			
    stringBuffer.append(TEXT_154);
    
			}else{
			
    stringBuffer.append(TEXT_155);
    
			}
			
    stringBuffer.append(TEXT_156);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_159);
    } else {
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_162);
    }
    stringBuffer.append(TEXT_163);
    
			    if(isMsCrm2016OnPremise) {
			
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(domain);
    stringBuffer.append(TEXT_169);
    
			    } else {
			
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(applicationId);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(authority);
    stringBuffer.append(TEXT_175);
    
                }
            
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(attemptsInterval);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(reuseHttpClient);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(serviceURL);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    
	     		String logical = ElementParameterParser.getValue(node,"__LOGICAL_OP__");
	     		boolean isSpecifyComplexFilter="true".equals(ElementParameterParser.getValue(node, "__SPECIFY_COMPLEX_FILTER__"));
	     		if(isSpecifyComplexFilter){
	     			String customQueryFilter = ElementParameterParser.getValue(node, "__CUSTOM_FILTER__");
	     			
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(customQueryFilter);
    stringBuffer.append(TEXT_191);
    
	     		}else{
		     		List<Map<String, String>> keyColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CONDITIONS__");
		        	if(keyColumns.size()>0 ){
					
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    
		            for(Map<String, String> keyColumn:keyColumns){
		        		
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(keyColumn.get("INPUT_COLUMN"));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(keyColumn.get("OPERATOR"));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(keyColumn.get("RVALUE"));
    stringBuffer.append(TEXT_202);
    
		        		}
		        		
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(logical);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    
		        	}
	     		}
	     		boolean isOrderBy="true".equals(ElementParameterParser.getValue(node, "__ORDER_BY__"));
	     		List<Map<String, String>> orderByColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ORDER_BY_TABLE__");
	     		if(isOrderBy && orderByColumns.size()>0){
	        		StringBuilder sbOrderBy = new StringBuilder();
	        		for(int i=0;i<orderByColumns.size();i++){
	        			Map<String, String> orderByColumn =orderByColumns.get(i);
	        			if(i!=0){
	        				sbOrderBy.append(",");
	        			}
	        			sbOrderBy.append(orderByColumn.get("COLUMN_NAME"));
	        			if("true".equalsIgnoreCase(orderByColumn.get("DESC"))){
	        				sbOrderBy.append(" desc");
	        			}
	        		}
	        		
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(sbOrderBy.toString());
    stringBuffer.append(TEXT_211);
    
	     		}
	        	StringBuilder sb = new StringBuilder("");
	        	for(IMetadataColumn column: columnList){
	  				sb.append("\"");
	  				sb.append(column.getLabel());
	  				sb.append("\",");
	        	}
	        	sb.deleteCharAt(sb.lastIndexOf(","));
	        	IConnection outgoingConn = outgoingConns.get(0);
				if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	        	
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(sb);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    
					if(isOrderBy && orderByColumns.size()>0){
					
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    
					}
					
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    
							for(int i = 0; i < columnList.size(); i++){//for begin
	
								IMetadataColumn column = columnList.get(i);
	
								String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
	
								JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
	
								String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
								
    stringBuffer.append(TEXT_237);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_241);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    
		       						if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
		        					
    stringBuffer.append(TEXT_246);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_247);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_248);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    
		        					}else if(javaType == JavaTypesManager.DATE){ // Date
		        					
    stringBuffer.append(TEXT_251);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_252);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_253);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_256);
    
		        					}else if(javaType == JavaTypesManager.BYTE_ARRAY){ // Byte[]
		        					
    stringBuffer.append(TEXT_257);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_264);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_265);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_269);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_270);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    
		        					}else{ // other
		        					
    stringBuffer.append(TEXT_273);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_274);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_275);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    
		        					}
		        					
    stringBuffer.append(TEXT_279);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_280);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_281);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_282);
    
							}//for end
							
    stringBuffer.append(TEXT_283);
    
			}
		}
	}
}

    
    	  }else{
        
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {
	IMetadataTable metadata = metadatas.get(0);

	if (metadata != null) {
		List<IMetadataColumn> columnList = metadata.getListColumns();
		int nbSchemaColumns = columnList.size();
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();

		// if output columns are defined
		if(nbSchemaColumns > 0 && outgoingConns != null && outgoingConns.size() > 0){
			String authType = ElementParameterParser.getValue(node, "__AUTH_TYPE__");
			String endpointURL = ElementParameterParser.getValue(node, "__ENDPOINTURL__");
			String orgName = ElementParameterParser.getValue(node, "__ORGNAME__");
			String username = ElementParameterParser.getValue(node, "__USERNAME__");

			String domain = ElementParameterParser.getValue(node, "__DOMAIN__");
			String host = ElementParameterParser.getValue(node, "__HOST__");
			String port = ElementParameterParser.getValue(node, "__PORT__");
			String timeoutSecTemp = ElementParameterParser.getValue(node, "__TIMEOUT__");
			String timeoutSec = (timeoutSecTemp!=null&&!("").equals(timeoutSecTemp))?timeoutSecTemp:"2";
			int timeout = (int)(Double.valueOf(timeoutSec) * 1000);
			boolean reuseHttpClient = ("true").equals(ElementParameterParser.getValue(node,"__REUSE_HTTP_CLIENT__"));
			boolean debug = ("true").equals(ElementParameterParser.getValue(node,"__DEBUG__"));
			boolean isAPI2011 = ("API_2011").equals(ElementParameterParser.getValue(node,"__API_VERSION__"));
			String discWSDL = ElementParameterParser.getValue(node, "__DISC_WSDL__");
			if(debug){
    stringBuffer.append(TEXT_284);
    }else{
    stringBuffer.append(TEXT_285);
    }

			String passwordFieldName = "__PASSWORD__";
			
    stringBuffer.append(TEXT_286);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_289);
    } else {
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_292);
    }
    stringBuffer.append(TEXT_293);
    
			if(!isAPI2011 || ("ON_PREMISE").equals(authType)){
				if(("ON_PREMISE").equals(authType)){
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(endpointURL);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(domain);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(reuseHttpClient);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(orgName);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    }else if(("ONLINE").equals(authType)){
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(orgName);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(reuseHttpClient);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(orgName);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    }
    stringBuffer.append(TEXT_366);
    
	     		String entityname = ElementParameterParser.getValue(node, "__ENTITYNAME__").trim();
	     		String customEntityname = ElementParameterParser.getValue(node, "__CUSTOM_ENTITY_NAME__");
	     		if("CustomEntity".equals(entityname)){
					entityname = customEntityname.replaceAll("\"","");
				}
	     		String entitynamealllower = entityname.toLowerCase();
	     		String logical = ElementParameterParser.getValue(node,"__LOGICAL_OP__");
	     		List<Map<String, String>> keyColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CONDITIONS__");
	     		
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    
	        	if(keyColumns.size()>0 ){
	            	StringBuffer conditionList = new StringBuffer("");
	            	int nbCondition = 0;
	            	for(Map<String, String> keyColumn:keyColumns){
	            		nbCondition++;
	            		String conditionID = cid + "_" + String.valueOf(nbCondition);
	        			
    stringBuffer.append(TEXT_371);
    stringBuffer.append(conditionID);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(conditionID);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(keyColumn.get("INPUT_COLUMN"));
    stringBuffer.append(TEXT_374);
    stringBuffer.append(conditionID);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(keyColumn.get("OPERATOR"));
    stringBuffer.append(TEXT_376);
    
	        			if(!("").equals(keyColumn.get("RVALUE"))){
	        			
    stringBuffer.append(TEXT_377);
    stringBuffer.append(conditionID);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(conditionID);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(conditionID);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(keyColumn.get("RVALUE"));
    stringBuffer.append(TEXT_381);
    stringBuffer.append(conditionID);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(conditionID);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(conditionID);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(conditionID);
    stringBuffer.append(TEXT_385);
    
	            		}
	            		conditionList.append("condition_"+conditionID+",");
	        		}
	        		conditionList.deleteCharAt(conditionList.lastIndexOf(","));
	        		
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(conditionList);
    stringBuffer.append(TEXT_389);
    
	        		if(!("").equals(logical)){
	        		
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(logical);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    
	        		}
	        	}
	        	
    stringBuffer.append(TEXT_398);
    
	        	StringBuilder sb = new StringBuilder("");
	        	for(IMetadataColumn column: columnList){
	  				sb.append("\"");
	  				sb.append(column.getLabel());
	  				sb.append("\",");
	        	}
	        	sb.deleteCharAt(sb.lastIndexOf(","));
	        	IConnection outgoingConn = outgoingConns.get(0);
				if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	        	
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(sb);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(entitynamealllower);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    boolean debugPaging=false;
	        	if(debugPaging){
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    }
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    //2009-04-14T10:09:42-07:00 ---> 2009-04-14T10:09:42-0700
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_553);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_586);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_633);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_640);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_642);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_647);
    
							for( int i = 0; i < columnList.size(); i++) {

								IMetadataColumn column = columnList.get(i);

								String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());

								JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());

								String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
								
    stringBuffer.append(TEXT_648);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_649);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_650);
    
	        						if (javaType == JavaTypesManager.STRING) {
	        					
    stringBuffer.append(TEXT_651);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_652);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_653);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_654);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_655);
    
	        						} else if(javaType == JavaTypesManager.DATE) { // Date
	        					
    stringBuffer.append(TEXT_656);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_657);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_658);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_659);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_660);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_661);
    
	        						} else if(javaType == JavaTypesManager.DOUBLE) { // Double
	        					
    stringBuffer.append(TEXT_662);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_663);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_664);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_665);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_666);
    
	        						} else if(javaType == JavaTypesManager.BIGDECIMAL) { // BigDecimal
	        					
    stringBuffer.append(TEXT_667);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_668);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_669);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_670);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_671);
    
	        						} else if(javaType == JavaTypesManager.FLOAT) { // Float
	        					
    stringBuffer.append(TEXT_672);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_673);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_674);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_675);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_676);
    
	        						} else if(javaType == JavaTypesManager.INTEGER) { // Integer
	        					
    stringBuffer.append(TEXT_677);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_678);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_679);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_680);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_681);
    
	        						} else if(javaType == JavaTypesManager.BOOLEAN) { // Boolean
	        					
    stringBuffer.append(TEXT_682);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_683);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_684);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_685);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_686);
    
	        						} else if(javaType == JavaTypesManager.OBJECT) { // OBJECT
	        					
    stringBuffer.append(TEXT_687);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_688);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_689);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_690);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_691);
    
	        						} else  { // other
	        					
    stringBuffer.append(TEXT_692);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_693);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_694);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_695);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_696);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_697);
    
	        						}
	        					
    stringBuffer.append(TEXT_698);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_699);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_700);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_701);
    
							}
							
    stringBuffer.append(TEXT_702);
    
				}

			}else{//api 2011
			
    stringBuffer.append(TEXT_703);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_704);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_705);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_706);
    stringBuffer.append(orgName);
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_708);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_710);
    stringBuffer.append(reuseHttpClient);
    stringBuffer.append(TEXT_711);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_712);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_713);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_714);
    stringBuffer.append(attemptsInterval);
    stringBuffer.append(TEXT_715);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_716);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_717);
    stringBuffer.append(discWSDL);
    stringBuffer.append(TEXT_718);
    
	     		String entityname = ElementParameterParser.getValue(node, "__ENTITYNAME__").trim();
	     		String customEntityname = ElementParameterParser.getValue(node, "__CUSTOM_ENTITY_NAME__");
	     		if("CustomEntity".equals(entityname)){
					entityname = customEntityname.replaceAll("\"","");
				}
	     		String entitynamealllower = entityname.toLowerCase();
	     		String logical = ElementParameterParser.getValue(node,"__LOGICAL_OP__");
	     		List<Map<String, String>> keyColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CONDITIONS__");
	     		
    stringBuffer.append(TEXT_719);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_720);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_721);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_722);
    
	        	if(keyColumns.size()>0 ){
				
    stringBuffer.append(TEXT_723);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_724);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_725);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_726);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_727);
    
	            	for(Map<String, String> keyColumn:keyColumns){
	        		
    stringBuffer.append(TEXT_728);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_729);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_730);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_731);
    stringBuffer.append(keyColumn.get("INPUT_COLUMN"));
    stringBuffer.append(TEXT_732);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_733);
    stringBuffer.append(keyColumn.get("OPERATOR"));
    stringBuffer.append(TEXT_734);
    
	        			if(!("").equals(keyColumn.get("RVALUE"))){
	        			
    stringBuffer.append(TEXT_735);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_736);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_737);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_738);
    stringBuffer.append(keyColumn.get("RVALUE"));
    stringBuffer.append(TEXT_739);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_740);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_741);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_742);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_743);
    
	            		}
	        		}
	        		
    stringBuffer.append(TEXT_744);
    
	        		if(!("").equals(logical)){
	        		
    stringBuffer.append(TEXT_745);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_746);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_747);
    stringBuffer.append(logical);
    stringBuffer.append(TEXT_748);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_749);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_750);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_751);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_752);
    
	        		}
	        	}
	        	
    stringBuffer.append(TEXT_753);
    
	        	StringBuilder sb = new StringBuilder("");
	        	for(IMetadataColumn column: columnList){
	  				sb.append("\"");
	  				sb.append(column.getLabel());
	  				sb.append("\",");
	        	}
	        	sb.deleteCharAt(sb.lastIndexOf(","));
	        	IConnection outgoingConn = outgoingConns.get(0);
				if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	        	
    stringBuffer.append(TEXT_754);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_755);
    stringBuffer.append(sb);
    stringBuffer.append(TEXT_756);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_757);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_758);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_759);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_760);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_761);
    stringBuffer.append(entitynamealllower);
    stringBuffer.append(TEXT_762);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_763);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_764);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_765);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_766);
    boolean debugPaging=false;
	        	if(debugPaging){
    stringBuffer.append(TEXT_767);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_768);
    }
    stringBuffer.append(TEXT_769);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_770);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_771);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_772);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_773);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_774);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_775);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_776);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_777);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_778);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_779);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_780);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_781);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_782);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_783);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_784);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_785);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_786);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_787);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_788);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_789);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_790);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_791);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_792);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_793);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_794);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_795);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_796);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_797);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_798);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_799);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_800);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_801);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_802);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_803);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_804);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_805);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_806);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_807);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_808);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_809);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_810);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_811);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_812);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_813);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_814);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_815);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_816);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_817);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_818);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_819);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_820);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_821);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_822);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_823);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_824);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_825);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_826);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_827);
    
						for(int i = 0; i < columnList.size(); i++){//for begin

							IMetadataColumn column = columnList.get(i);

							String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());

							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());

							String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
							
    stringBuffer.append(TEXT_828);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_829);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_830);
    
	       						if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
	        					
    stringBuffer.append(TEXT_831);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_832);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_833);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_834);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_835);
    
	        					}else if(javaType == JavaTypesManager.DATE){ // Date
	        					
    stringBuffer.append(TEXT_836);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_837);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_838);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_839);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_840);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_841);
    
	        					}else{ // other
	        					
    stringBuffer.append(TEXT_842);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_843);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_844);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_845);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_846);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_847);
    
	        					}
	        					
    stringBuffer.append(TEXT_848);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_849);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_850);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_851);
    
						}//for end
						
    stringBuffer.append(TEXT_852);
    
				}
			}
		}
	}
}

    
        }
    }

    stringBuffer.append(TEXT_853);
    return stringBuffer.toString();
  }
}
