package tw.epicer.model;

public class Image {
	private String picname;
	private String fulltemppath;

	public Image() {
		super();
	}



	public Image(String picname, String fulltemppath) {
		super();
		this.picname = picname;
		this.fulltemppath = fulltemppath;
	}



	public String getPicname() {
		return picname;
	}



	public void setPicname(String picname) {
		this.picname = picname;
	}



	public String getFulltemppath() {
		return fulltemppath;
	}



	public void setFulltemppath(String fulltemppath) {
		this.fulltemppath = fulltemppath;
	}

	public String geImageFile(String picname) {
		String filename="images"+"/";
		String Imagefile=filename.replace(" ","")+picname.replace(" ","");
		return Imagefile;
	}
	
	
}
