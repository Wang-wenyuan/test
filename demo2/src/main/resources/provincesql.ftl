





<#list province as k>
INSERT INTO "public"."province" VALUES ('${k.pId}', '${k.id}', '${k.name}');
</#list>
