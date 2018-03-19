package services.model;

public class RemoteFile {
	
	private String remotefilepath;
		public RemoteFile(String filepath) {
		super();
		// call setters for validations instead of directly setting
		this.setRemotefilepath(filepath);
	}
	
	public String getRemotefilepath() {
		return remotefilepath;
	}

	public void setRemotefilepath(String remotefilepath) {
		this.remotefilepath = remotefilepath;
	}
	

}
