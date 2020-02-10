package net.zabalburu.news.modelo.dto;

import java.util.List;

import net.zabalburu.news.modelo.Articulo;

public class NewsApiDTO {
	private String status;
	private int totalResults;
	private List<Articulo> articles;
	
	public NewsApiDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTotalResults() {
		return totalResults;
	}
	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}
	public List<Articulo> getArticles() {
		return articles;
	}
	public void setArticles(List<Articulo> articulos) {
		this.articles = articulos;
	}
	@Override
	public String toString() {
		return "NewsApiDTO [status=" + status + ", totalResults=" + totalResults + ", articulos=" + articles + "]";
	}
	
}
