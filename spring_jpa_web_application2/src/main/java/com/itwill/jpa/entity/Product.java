package com.itwill.jpa.entity;

import java.time.LocalDateTime;

import com.itwill.jpa.dto.ProductDto;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name = "product_seq", initialValue = 1, allocationSize = 1)
    private Long productId;
    private String name;
    private Integer price;
    private Integer stock;
    @CreationTimestamp // 제품 생성 시간을 JPA에서 자동 삽입
    @ColumnDefault("sysdate") // 제품 생성 시간을 SQL에서 자동 삽입
    @Column(updatable = false) // 제품 생성 시간은 수정되지 않도록 함
    private LocalDateTime createdAt;
    @UpdateTimestamp // JPA에서 제품 수정 시 수정한 시간 자동 업데이트
    private LocalDateTime updatedAt;

    public static Product toEntity(ProductDto productDto) {
        return Product.builder()
                .productId(productDto.getProductId())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .stock(productDto.getStock())
                .build();
    }
}
