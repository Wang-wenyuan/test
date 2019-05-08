
<#list district as k>
INSERT INTO "public"."district" VALUES ('${k.cityName}', '${k.cityIdId}', '<#if k.districtName ??>${k.districtName}<#else > null</#if>','<#if k.districtName ??>${k.districtId}<#else > null</#if>', '${k.id}','${k.provinceNo}');
</#list>