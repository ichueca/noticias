package net.zabalburu.news.modelo.dto;

import java.util.Arrays;
import java.util.List;

import net.zabalburu.news.modelo.Noticia;

public class NewsDTO {
	@Override
	public String toString() {
		return "NewsDTO [_type=" + _type + ", didUMean=" + didUMean + ", totalCount=" + totalCount + ", relatedSearch="
				+ Arrays.toString(relatedSearch) + ", value=" + value + "]";
	}
	private String _type;
	private String didUMean;
	private Integer totalCount;
	private String[] relatedSearch;
	private List<Noticia> value;
	public NewsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String get_type() {
		return _type;
	}
	public void set_type(String _type) {
		this._type = _type;
	}
	public String getDidUMean() {
		return didUMean;
	}
	public void setDidUMean(String didUMean) {
		this.didUMean = didUMean;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public String[] getRelatedSearch() {
		return relatedSearch;
	}
	public void setRelatedSearch(String[] relatedSearch) {
		this.relatedSearch = relatedSearch;
	}
	public List<Noticia> getValue() {
		return value;
	}
	public void setValue(List<Noticia> value) {
		this.value = value;
	}
	
		
	
	
}
