package com.group19.comment.g19_comment;

import com.group19.comment.g19_comment.entity.*;
import com.group19.comment.g19_comment.repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class G19CommentApplication {

    public static void main(String[] args) {
        SpringApplication.run(G19CommentApplication.class, args);
    }

    @Bean
    ApplicationRunner init(MemberRepository memberrepository, CategoryRepository categoryRepository,
                           RestaurantRepository restaurantRepository, CommentRepository commentRepository,
                           RatingRepository ratingRepository
    ) {
        return args -> {

            // set member

            Stream.of("Somsri", "Somchai","Copter").forEach(username -> {
                Member member = new Member();
                member.setUsername(username);
                memberrepository.save(member);
                if(username == "Somsri"){
                    member.setPassword("1111");
                    memberrepository.save(member);
                }
                if(username == "Somchai"){
                    member.setPassword("2222");
                    memberrepository.save(member);
                }
                if(username == "Copter"){
                    member.setPassword("3333");
                    memberrepository.save(member);
                }
            });
            memberrepository.findAll().forEach(System.out::println);

            // set category

            Stream.of(1L,2L,3L,4L,5L).forEach(ratinglevel -> {
                Rating rating = new Rating();
                rating.setRatinglevel(ratinglevel);
                ratingRepository.save(rating);
            });

            // set category

            Stream.of("Rice", "Grill").forEach(categoryName -> {
                Category category = new Category();
                category.setCategoryName(categoryName);
                categoryRepository.save(category);
            });
            categoryRepository.findAll().forEach(System.out::println);

            // set restaurant

            Stream.of("KorKok", "KaoGang").forEach(restaurantName -> {
                Restaurant restaurant = new Restaurant();
                restaurant.setRestaurantName(restaurantName);
                restaurantRepository.save(restaurant);

                if (restaurantName == "KorKok") {
                    restaurant.setAddress("SUT GATE 1");
                    restaurant.setRestaurantImg("korkok.jpg");
                    restaurant.setCategories(categoryRepository.getOne(2L));
                    restaurantRepository.save(restaurant);
                } else if (restaurantName == "KaoGang") {
                    restaurant.setAddress("SUT GATE 4");
                    restaurant.setRestaurantImg("ricegang.jpg");
                    restaurant.setCategories(categoryRepository.getOne(1L));
                    restaurantRepository.save(restaurant);
                }
            });
            restaurantRepository.findAll().forEach(System.out::println);

            //set comment
            Comment comment = new Comment();
            comment.setMembers(memberrepository.getOne(1L));
            comment.setRating(ratingRepository.getOne(5L));
            comment.setImg("cat.jpg");
            comment.setText("Somsri First Comment for KorKok :)");
            comment.setRestaurants(restaurantRepository.getOne(1L));
            commentRepository.save(comment);

            Comment comment2 = new Comment();
            comment2.setMembers(memberrepository.getOne(2L));
            comment2.setRating(ratingRepository.getOne(3L));
            comment2.setImg("dog.jpg");
            comment2.setText("Somchai Firsts Comment for KorKok >,<");
            comment2.setRestaurants(restaurantRepository.getOne(1L));
            commentRepository.save(comment2);
            commentRepository.findAll().forEach(System.out::println);

            Comment comment3 = new Comment();
            comment3.setMembers(memberrepository.getOne(2L));
            comment3.setRating(ratingRepository.getOne(5L));
            comment3.setImg("fox.jpg");
            comment3.setText("Somchai Second Comment for KaoGang :D");
            comment3.setRestaurants(restaurantRepository.getOne(2L));
            commentRepository.save(comment3);
            commentRepository.findAll().forEach(System.out::println);

            Comment comment4 = new Comment();
            comment4.setMembers(memberrepository.getOne(1L));
            comment4.setRating(ratingRepository.getOne(2L));
            comment4.setImg("apple.jpg");
            comment4.setText("Somsri Second Comment for KaoGang :<");
            comment4.setRestaurants(restaurantRepository.getOne(2L));
            commentRepository.save(comment4);
        };
    }
}
