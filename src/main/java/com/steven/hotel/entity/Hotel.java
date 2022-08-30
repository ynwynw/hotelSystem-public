package com.steven.hotel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.Authorization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author shkstart
 * @create 2021-07-23 23:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("hotel_info")
public class Hotel extends Model<Hotel> {
    @TableId(value = "hotel_id")
    private Long hotelId;

    @TableField(value = "chain_id")
    private Long chainId;

    @TableField(value = "chain_name")
    private String chainName;

    @TableField(value = "brand_id")
    private Long brandId;

    @TableField(value = "brand_name")
    private String brandName;

    @TableField(value = "hotel_name")
    private String hotelName;

    @TableField(value = "hotel_formerly_name")
    private String hotelFormerlyName;

    @TableField(value = "hotel_translated_name")
    private String hotelTranslatedName;


    private String addressline;
    private Long zipcode;
    private String state;
    private String country;
    private String countryisocode;

    @TableField(value = "star_rating")
    private float starRating;
    private float longitude;
    private float latitude;
    private String url;
    private String checkin;
    private String checkout;


    private int numberrooms;

    @TableField(value = "numberfloors")
    private int numberfloors;

    private String yearopened;
    private String yearrenovated;
    private String photo1;
    private String photo2;
    private String photo3;
    private String photo4;
    private String photo5;
    private String overview;


    @TableField(value = "rates_from")
    private int ratesFrom;

    @TableField(value = "continent_id")
    private int continentId;

    @TableField(value = "continent_name")
    private String continentName;

    @TableField(value = "city_id")
    private int cityId;

    @TableField(value = "country_id")
    private int countryId;

    @TableField(value = "number_of_reviews")
    private int numberOfReviews;

    @TableField(value = "rating_average")
    private float ratingAverage;

    @TableField(value = "rates_currency")
    private String ratesCurrency;

    private String city;
}

