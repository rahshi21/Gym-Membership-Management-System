package com.gm.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CreateRatingRequest {
	
	@NotNull
    private Long memberId;

    @NotNull
    private Long trainerId;

    @Min(1)
    @Max(5)
    private Integer rating;

    private String comment;

	public CreateRatingRequest() {
		super();
	}

	public CreateRatingRequest(@NotNull Long memberId, @NotNull Long trainerId, @Min(1) @Max(5) Integer rating,
			String comment) {
		super();
		this.memberId = memberId;
		this.trainerId = trainerId;
		this.rating = rating;
		this.comment = comment;
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

	

}
