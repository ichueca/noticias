package net.zabalburu.news.modelo;

public class Imagen {
	private String url;
	private Integer height;
	private Integer width;
	private String thumbnail;
	private Integer thumbnailHeight;
	private Integer thumbnailWidth;
	private Object base64Encoding;
	public Imagen() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public Integer getThumbnailHeight() {
		return thumbnailHeight;
	}
	public void setThumbnailHeight(Integer thumbnailHeight) {
		this.thumbnailHeight = thumbnailHeight;
	}
	public Integer getThumbnailWidth() {
		return thumbnailWidth;
	}
	public void setThumbnailWidth(Integer thumbnailWidth) {
		this.thumbnailWidth = thumbnailWidth;
	}
	public Object getBase64Encoding() {
		return base64Encoding;
	}
	public void setBase64Encoding(Object base64Encoding) {
		this.base64Encoding = base64Encoding;
	}
	
	
}
