package com.dandelion.board.repository;

import com.dandelion.board.entity.ItemImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ItemImage, Integer> {
}
