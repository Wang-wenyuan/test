

<#list city as k>
INSERT INTO "public"."city" VALUES ('${k.name}', '${k.cityId}', '${k.id}', '${k.provinceId}');
</#list>