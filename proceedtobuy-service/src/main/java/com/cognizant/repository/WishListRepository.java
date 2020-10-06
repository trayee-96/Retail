package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.VendorWishlist;
@Repository
public interface WishListRepository extends JpaRepository<VendorWishlist, Integer>{

}
