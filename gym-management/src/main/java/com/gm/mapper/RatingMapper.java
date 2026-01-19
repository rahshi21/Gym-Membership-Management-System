package com.gm.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.gm.dto.response.RatingResponse;
import com.gm.entity.Member;
import com.gm.entity.Rating;
import com.gm.entity.Trainer;

@Component
public class RatingMapper {

	public Rating toEntity(Member member, Trainer trainer, Integer rating, String comment) {

		Rating r = new Rating();
		r.setMember(member);
		r.setTrainer(trainer);
		r.setRating(rating);
		r.setComment(comment);
		r.setCreatedAt(LocalDateTime.now());

		return r;
	}

	public RatingResponse toResponse(Rating rating) {

		RatingResponse response = new RatingResponse();
		response.setRatingId(rating.getId());
		response.setMemberId(rating.getMember().getId());
		response.setTrainerId(rating.getTrainer().getId());
		response.setRating(rating.getRating());
		response.setComment(rating.getComment());
		response.setCreatedAt(rating.getCreatedAt());

		return response;
	}

}
