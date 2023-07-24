package iot.sh.page;

import java.io.Serializable;

public class Page implements Serializable{

	private static final long serialVersionUID = 2285730225527147018L;
	
	private int nPageIndex = 1;
	private int nPageSize = 15;
	private long nTotalPage;
	private long nCount;
	private int nStartRecord;
	
	public int getnPageIndex() {
		return nPageIndex;
	}
	public Page setnPageIndex(int nPageIndex) {
		if(nPageIndex<=0)
			nPageIndex=1;
		this.nPageIndex = nPageIndex;
		return this;
	}
	public int getnPageSize() {
		return nPageSize;
	}
	public Page setnPageSize(int nPageSize) {
		if(nPageSize>200)
			nPageSize=200;
		if(nPageSize<=0)
			nPageSize=10;
		this.nPageSize = nPageSize;
		return this;
	}
	public long getnTotalPage() {
		if (nCount % nPageSize == 0) {
			nTotalPage = nCount / nPageSize;
		} else {
			nTotalPage = nCount / nPageSize + 1;
		}
		if(nTotalPage<=0)
			nTotalPage=1;
		return nTotalPage;		
	}
	
	public long getnCount() {
		return nCount;
	}
	
	public void setnCount(long nCount) {
		this.nCount = nCount;
	}
	
	public int getnStartRecord() {
		long nTotalPage=getnTotalPage();
		if(nPageIndex>nTotalPage){
			nPageIndex=(int)nTotalPage;
		}
		nStartRecord = (nPageIndex - 1) * nPageSize;		
		return nStartRecord;		
	}
}
