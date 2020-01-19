package com.demo;

import java.io.File;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class FileUploadClass {


	final static String accesskey = "AKIAIHNU2K4KT5OAISKA";
	final static String secretkey = "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";
	final static String bucketname = "development.optimisation";
	private static final String SUFFIX = "/";
	
	AmazonS3Client s3client=new AmazonS3Client(new BasicAWSCredentials(accesskey,secretkey));
	
	
	
	public String uploadFile(String pathFors3,String folder,String s,String filename)
	{
		
		String key = s+SUFFIX+folder+SUFFIX+filename;
	//	String folderName = bucketname+SUFFIX+s;
		System.out.println("hiii");
		//AccessControlList acl = new AccessControlList();
		//acl.grantPermission(GroupGrantee.AllUsers, Permission.Read);
		
		
		System.out.println("no error...");
		s3client.putObject(new PutObjectRequest(bucketname, key,new File(pathFors3)).withCannedAcl(CannedAccessControlList.PublicRead));
		
		String url = s3client.getUrl(bucketname, key).toString();
		System.out.println(url);
		return url;
	
		//https://s3.ap-south-1.amazonaws.com/cbesu/kena2011997%40gmail.com/kens/shikha.txt
		//https://cbesu.s3.amazonaws.com/kens/shikha.txt
	}
	
	public static void main(String args[]) {
		
		FileUploadClass obj = new FileUploadClass();
		obj.uploadFile("/Users/zeba/innoventa-workspace/File_Operations/1.txt", "src", "vakilzeba@gmail.com", "us.txt");
	}
}
