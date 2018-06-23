package gists.model;

import java.util.List;

import org.json.simple.JSONObject;

public class Gist {
	
	
	
	public JSONObject setGist(String description, boolean isPublic, String fileName, String content) {
		
		JSONObject newGist = new JSONObject();
		newGist.put("description", description);
		newGist.put("public", isPublic);
		
		
		
		JSONObject newFile = new JSONObject();
		JSONObject newContent = new JSONObject();
		
		newContent.put("content", content);
		newFile.put("file1.txt",newContent);
		newGist.put("files", newFile);
		
	
		
		return newGist;
	}
	

	
	

}
