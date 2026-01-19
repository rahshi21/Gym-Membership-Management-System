package com.gm.dto.response;

import java.time.LocalDateTime;

public class RatingResponse {

	private Long ratingId;
	private Long memberId;
	private Long trainerId;
	private Integer rating; // 1 to 5
	private String comment;
	private LocalDateTime createdAt;

	public RatingResponse() {
		super();
	}

	public RatingResponse(Long ratingId, Long memberId, Long trainerId, Integer rating, String comment,
			LocalDateTime createdAt) {
		super();
		this.ratingId = ratingId;
		this.memberId = memberId;
		this.trainerId = trainerId;
		this.rating = rating;
		this.comment = comment;
		this.createdAt = createdAt;
	}

	public Long getRatingId() {
		return ratingId;
	}

	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Long trainerId) {
		this.trainerId = trainerId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
