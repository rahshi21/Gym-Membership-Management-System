package com.gm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gm.dto.request.CreateRatingRequest;
import com.gm.dto.response.RatingResponse;
import com.gm.entity.Member;
import com.gm.entity.Rating;
import com.gm.entity.Trainer;
import com.gm.exception.MemberNotFoundException;
import com.gm.exception.TrainerNotFoundException;
import com.gm.mapper.RatingMapper;
import com.gm.repository.MemberRepository;
import com.gm.repository.RatingRepository;
import com.gm.repository.TrainerRepository;

@Service
public class RatingService{
	
	Logger logger = LoggerFactory.getLogger(RatingService.class);

	@Autowired
	private RatingRepository ratingRepository;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private TrainerRepository trainerRepository;
	
	@Autowired
	private RatingMapper mapper;

	public RatingResponse addRating(CreateRatingRequest request) {

		Member member = memberRepository.findById(request.getMemberId())
				.orElseThrow(() -> new MemberNotFoundException("Member not found"));

		Trainer trainer = trainerRepository.findById(request.getTrainerId())
				.orElseThrow(() -> new TrainerNotFoundException("Trainer not found"));

		Rating rating = mapper.toEntity(member, trainer, request.getRating(), request.getComment());

		Rating saved = ratingRepository.save(rating);

		return mapper.toResponse(saved);
	}

	public List<RatingResponse> getRatingsByTrainer(Long trainerId) {

		List<Rating> ratings = ratingRepository.findByTrainerId(trainerId);
		List<RatingResponse> responses = new ArrayList<>();

		for (Rating rating : ratings) {
			responses.add(mapper.toResponse(rating));
		}

		return responses;
	}
	
	public List<RatingResponse> getRatingsByMember(Long id) {

        List<Rating> ratings = ratingRepository.findByMemberId(id);
        List<RatingResponse> responses = new ArrayList<>();

        for (Rating rating : ratings) {
            responses.add(mapper.toResponse(rating));
        }

        return responses;
    }


	public List<RatingResponse> getAllRatings(Long memberId) {

		return ratingRepository.findAll()
				.stream()
				.map(mapper::toResponse)
				.collect(Collectors.toList());
	}
}
