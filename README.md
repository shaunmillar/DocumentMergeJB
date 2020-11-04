## Document Merge Service (JBOSS 6.4.5 version) 

A RESTful Document Merge Service. 

## Swagger-UI endpoint
http://localhost:8080/docmerge/swagger-ui.html

## API Endpoints

Basic Merge
http://localhost:8080/docmerge/merge/{correlationId}

## Maven build
mvn clean install -DskipTests

## Building AEM tools with Maven
https://helpx.adobe.com/ca/experience-manager/6-3/sites/developing/using/ht-projects-maven.html
https://helpx.adobe.com/aem-forms/6/aem-livecycle-connector.html#AdobeLiveCycleAssemblerClientbundle

## AEM engine (dev)
AEM version : v6.2.0, GM

## Request Example

{
   "options":{
      "forcePDFAOnLoad": true,  	<-- Forces XFA document types to PDF/A prior to merge. AEM cannot merge XFA documents (at present)
      "createToC": true  			<-- Creates first page as Table of Contents.
   },
   "documents":[
      {
         "id":"optional",			<-- Document ID. Currently not used by may be used in Future as Bookmark label.
         "docType":"pdf",			<-- must be 'pdf'. No other document types supported yet.
         "order":1,					<-- Output order. Starts with 1. Second document is 2, and on. 
         "data":"SGVsbG9Xb3JsZA==" 	<-- Base64 encoded input document (PDF).
      },
      {
         "id":"optional",
         "docType":"pdf",
         "order":2,
         "data":"SGVsbG9Xb3JsZA=="
      }
   ]
}

## Installing on JBOSS

Before the resulting war file (see target folder) is deployed to the JBOSS server, the module path must be created, and two files added to the new path. 

New module path to ve created on server: modules/system/layers/base/ca/bc/gov/pssg/docmerge/main

Add module.xml to new path. Contents:

<?xml version="1.0" encoding="UTF-8"?>
<module xmlns="urn:jboss:module:1.0" name="ca.bc.gov.pssg.docmerge">
        <resources>
                <resource-root path="."/>
        </resources>
</module>

Add docmerge.properties. Contents: 

docmerge.aem.endpoint=[AEM sever endpoint]
docmerge.aem.user=[AEM server username]
docmerge.aem.password=[AEM server password]

Lastly, bounce the server. Then deploy the WAR file resulting from the build. 






