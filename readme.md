**Two Approaches**

```
1.Contract First


WSDL-->Java


2.Contract Last

Java--->WSDL

```

**Contract First approach**

```
When using Spring Boot we do not need to generate/create the WSDL


We use an xsd file and the Spring boot creates the WSDL File

```


**Service Developed**
**Loan Evaluation API**

```
I am going to create an api to determine the customer loan eligibility


```

**XSD FILE**

```
It contains the structure of my Requests and Responses.

In spring we create just the XSD and Java creates for us the WSDL

Steps

1.Creating the XSD

The XSD contains the structure of my Requests and Responses


2.Creating our Binding Classes

We then create our binding classes from XSD

Even when consuming Soap i have to have classes that will nest
my XML to my Spring Application.

My spring boot application will communicate to myXML through the
help of these binding classes.

Creates for me packages that will help me reach my XML classes 


3.Remember i need to have a WSDL file after developing my service
since SOAP requests are consumed from the WSDL file.


```

**WSDL**

```aidl

My Understainding of the WSDL file is that is is the final
package that has the functionality of my web service embedded
into it.

```

**New Things Learnt**

```aidl

1.Spring boot dev tools,

It hot reloads my application.

2.Remember that this is not a Rest Service, so my annotations are

@Endpoing and not @RestController,


```