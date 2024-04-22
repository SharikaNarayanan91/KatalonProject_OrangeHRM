<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description></description>
   <name>LoginSuite</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>0</numberOfRerun>
   <pageLoadTimeout>30</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <rerunImmediately>false</rerunImmediately>
   <testSuiteGuid>403517ef-ac9a-4233-915e-b3408d52d947</testSuiteGuid>
   <testCaseLink>
      <guid>874440b4-9ee0-4750-99e5-21067f63611f</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Login/TC01_Login_ValidCredentials</testCaseId>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
   </testCaseLink>
   <testCaseLink>
      <guid>99e1228a-7f4a-4975-82b7-6d2dcf82e7bf</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Login/TC02_Login_InvalidCredentials</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>1838baa9-ceea-429c-b8ec-612925845fa4</id>
         <iterationEntity>
            <iterationType>RANGE</iterationType>
            <value>1-3</value>
         </iterationEntity>
         <testDataId>Data Files/LoginData</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>1838baa9-ceea-429c-b8ec-612925845fa4</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Username</value>
         <variableId>66c52237-63c5-441d-9250-d79635b27387</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>1838baa9-ceea-429c-b8ec-612925845fa4</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Password</value>
         <variableId>c98cde9c-a5dd-4ca1-9bf0-f45748dacd48</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>1838baa9-ceea-429c-b8ec-612925845fa4</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>ErrorMessage</value>
         <variableId>261b8122-85a4-44ab-9991-eca2c7683448</variableId>
      </variableLink>
   </testCaseLink>
</TestSuiteEntity>