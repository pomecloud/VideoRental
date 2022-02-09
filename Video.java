import java.util.Date;

public class Video {
	private String title ;

	private int priceCode ;
	public static final int REGULAR = 1 ;
	public static final int NEW_RELEASE =2 ;

	private VideoType videoType ;
	private Date registeredDate ;
	private boolean rented ;
/*
	public Video(String title, int videoType, int priceCode, Date registeredDate) {
		this.setTitle(title) ;
		this.setVideoType(videoType) ;
		this.setPriceCode(priceCode) ;
		this.registeredDate = registeredDate ;
	}
*/
	public Video(String title, VideoType videoType, int priceCode, Date registeredDate){
		this.setTitle(title) ;
		this.setVideoType(videoType) ;
		this.setPriceCode(priceCode) ;
		this.registeredDate = registeredDate ;
	}

	public int getLateReturnPointPenalty() {
		return videoType.getPenalty();
	}
	public boolean isNewRelease(){
		return getPriceCode() == NEW_RELEASE;
	}
	public boolean isRegular(){
		return getPriceCode() == REGULAR;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public VideoType getVideoType() {
		return videoType;
	}

	public void setVideoType(VideoType videoType) {
		this.videoType = videoType;
	}

	public double getCharge(int daysRented){
		double charge = 0;

		if (isRegular()){
			charge += 2;
			if (daysRented > 2)
				charge += (daysRented - 2) * 1.5;
		}else if(isNewRelease()){
			charge = daysRented * 3;
		}

		return charge;
	}
}
