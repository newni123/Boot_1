package com.iu.b1.util;

public class Pager {

	private Integer startNum;
	private Integer lastNum;
	private Integer startRow;
	private Integer lastRow;
	private Integer curPage;
	private Integer perPage;
	private Integer totalBlock;
	private Integer curBlock;
	private String kind;
	private String search;

	public Pager() {
		perPage = 10;
	}

	public Integer getStartNum() {
		return startNum;
	}

	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}

	public Integer getLastNum() {
		return lastNum;
	}

	public void setLastNum(Integer lastNum) {
		this.lastNum = lastNum;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getLastRow() {
		return lastRow;
	}

	public void setLastRow(Integer lastRow) {
		this.lastRow = lastRow;
	}

	public Integer getCurPage() {
		if (curPage == null || curPage == 0)
			curPage = 1;
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getPerPage() {
		if (perPage == null || perPage == 0)
			perPage = 10;
		return perPage;
	}

	public Integer getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(Integer curBlock) {
		this.curBlock = curBlock;
	}

	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}

	public Integer getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock(Integer totalBlock) {
		this.totalBlock = totalBlock;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if (search == null)
			search = "";
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public void makeRow() {
		startRow = (this.getCurPage() - 1) * this.getPerPage() + 1; // 그냥 멤버변수로 호출하면 Null값이 들어 갈수도 있으니까 꼭 메서드 형식으로
		lastRow = this.getCurPage() * this.getPerPage();
	}

	public void makePage(int totalCount) {
		// 2. totalPage 구하기
		int totalPage = totalCount / this.getPerPage();
		if (totalCount % getPerPage() != 0)
			totalPage++;
		// 3. totalBlock
		int perBlock = 5; // 한번에 보여 지는 블럭 수
		totalBlock = totalPage / perBlock; // 전체 블럭 수
		if (totalPage % perBlock != 0)
			totalBlock++;
		// 4. curPage로 curBlock 구하기
		curBlock = this.getCurPage() / perBlock;
		if (this.getCurPage() % perBlock != 0)
			curBlock++;
		// 5. curBlock으로 startNum, lastNum
		startNum = (curBlock - 1) * perBlock + 1;
		lastNum = curBlock * perBlock;
		if (curBlock == totalBlock)
			lastNum = totalPage;

	}

}
