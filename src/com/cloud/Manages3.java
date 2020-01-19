package com.cloud;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;


import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;



import com.amazonaws.services.s3.AmazonS3;


import com.amazonaws.services.s3.model.CannedAccessControlList;

public class Manages3 
{
	final static String accesskey = "AKIAIHNU2K4KT5OAISKA";
	final static String secretkey = "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";
	final static String bucketname = "development.optimisation";
	private static final String SUFFIX = "/";
	
	AmazonS3Client s3client=new AmazonS3Client(new BasicAWSCredentials(accesskey,secretkey));
	
	
	public void createUser(String folderName) 
	{
		// create meta-data for your folder and set content-length to 0
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(0);

		// create empty content
		InputStream emptyContent = new ByteArrayInputStream(new byte[0]);

		// create a PutObjectRequest passing the folder name suffixed by /
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketname,
				folderName + SUFFIX, emptyContent, metadata);

		// send request to S3 to create folder
		s3client.putObject(putObjectRequest);
	}


	public void createProject(String email, String projectName) {
		// TODO Auto-generated method stub
		

		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(0);

		// create empty content
		InputStream emptyContent = new ByteArrayInputStream(new byte[0]);

		// create a PutObjectRequest passing the folder name suffixed by /
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketname,
				email+"/"+projectName+"/src/com" + SUFFIX, emptyContent, metadata);

		s3client.putObject(putObjectRequest);
		
		//-------------------------for Controller---------------------------
		ObjectMetadata metadatacontroller = new ObjectMetadata();
		metadatacontroller.setContentLength(0);

		// create empty content
		InputStream emptyContentcontroller = new ByteArrayInputStream(new byte[0]);

		PutObjectRequest putObjectRequestcontroller = new PutObjectRequest(bucketname,
				email+"/"+projectName+"/src/com/controller" + SUFFIX, emptyContentcontroller, metadatacontroller);
		
		
		// send request to S3 to create folder
		s3client.putObject(putObjectRequestcontroller);
		
		//-----------------for DAO----------------------------------------
		ObjectMetadata metadataDAO = new ObjectMetadata();
		metadatacontroller.setContentLength(0);

		// create empty content
		InputStream emptyContentDAO = new ByteArrayInputStream(new byte[0]);

		PutObjectRequest putObjectRequestDAO = new PutObjectRequest(bucketname,
				email+"/"+projectName+"/src/com/DAO" + SUFFIX, emptyContentDAO, metadataDAO);
		
		
		// send request to S3 to create folder
		s3client.putObject(putObjectRequestDAO);
		
		//-----------------for VO----------------------------------------
				ObjectMetadata metadataVO = new ObjectMetadata();
				metadatacontroller.setContentLength(0);

		// create empty content
		InputStream emptyContentVO = new ByteArrayInputStream(new byte[0]);
		PutObjectRequest putObjectRequestVO = new PutObjectRequest(bucketname,
		email+"/"+projectName+"/src/com/VO" + SUFFIX, emptyContentVO, metadataVO);
				
				
				// send request to S3 to create folder
				s3client.putObject(putObjectRequestVO);
		
		
		//-----END--------------
		
		ObjectMetadata metadata1 = new ObjectMetadata();
		metadata1.setContentLength(0);

		// create empty content
		InputStream emptyContent1 = new ByteArrayInputStream(new byte[0]);

		PutObjectRequest putObjectRequest1 = new PutObjectRequest(bucketname,
				email+"/"+projectName+"/WebContent/WEB-INF" + SUFFIX, emptyContent1, metadata1);
		
		
		// send request to S3 to create folder
		
		s3client.putObject(putObjectRequest1);
		
		//-----------view-----------
		ObjectMetadata metadataview = new ObjectMetadata();
		metadata1.setContentLength(0);

		// create empty content
		InputStream emptyContentview = new ByteArrayInputStream(new byte[0]);

		PutObjectRequest putObjectRequestview = new PutObjectRequest(bucketname,
				email+"/"+projectName+"/WebContent/WEB-INF/view" + SUFFIX, emptyContentview, metadataview);
		
		
		// send request to S3 to create folder
		s3client.putObject(putObjectRequestview);
	}
	//-----------module-----------

	public void createModule(String email, String projectName,String moduleName)
	{
		ObjectMetadata metadatamodule = new ObjectMetadata();
		metadatamodule.setContentLength(0);

		// create empty content
		InputStream emptyContentmodule = new ByteArrayInputStream(new byte[0]);

		PutObjectRequest putObjectRequestmodule = new PutObjectRequest(bucketname,
				email+"/"+projectName+"/WebContent/WEB-INF/view"+"/"+moduleName + SUFFIX, emptyContentmodule, metadatamodule);
		
		
		// send request to S3 to create folder
		s3client.putObject(putObjectRequestmodule);
	}
	public String fileUpload(String email,String projectName,String fileType,String VOFilePath,String moduleName,String formName)
	{
        String key  = email+SUFFIX+projectName+SUFFIX+"WebContent"+SUFFIX+"WEB-INF"+SUFFIX+"view"+SUFFIX+moduleName+SUFFIX+formName+".java";
        System.out.println("Path:::::::::"+VOFilePath);
      
    		System.out.println("hiii");
    		
    		System.out.println("no error...");
    		s3client.putObject(new PutObjectRequest(bucketname, key,new File(VOFilePath)).withCannedAcl(CannedAccessControlList.PublicRead));
    		
    		String url = s3client.getUrl(bucketname, key).toString();
    		System.out.println(url);
    		return url;
   
    	}
}	

