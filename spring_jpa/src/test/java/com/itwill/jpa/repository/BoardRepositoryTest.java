package com.itwill.jpa.repository;

import com.itwill.SpringJpaApplicationTests;
import com.itwill.jpa.entity.Board;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardRepositoryTest extends SpringJpaApplicationTests {
    @Autowired
    BoardRepository boardRepository;

    //    @Disabled
    @Test
    void board_select() {
        List<Board> boardList = boardRepository.findAll();
        for (Board board : boardList) {
            System.out.println(board);
        }
    }

    //    @Disabled
    @Test
    void board_select_page() {
        List<Board> boardList = boardRepository.findAll();
        System.out.println("boardList.size() = " + boardList.size());
        /*
		 << Pageable 인터페이스에는 다음과 같은 주요 메서드와 속성이 있습니다. >>
			int getPageNumber(): 현재 페이지 번호를 반환합니다. 페이지 번호는 0부터 시작합니다.
			int getPageSize(): 한 페이지에 표시될 항목 수를 반환합니다.
			int getOffset(): 현재 페이지의 시작 오프셋을 반환합니다. 시작 오프셋은 0부터 시작합니다.
			Sort getSort(): 정렬 정보를 반환합니다. 이를 통해 페이지의 결과를 원하는 방식으로 정렬할 수 있습니다.
			Pageable next(): 다음 페이지로 이동하기 위한 Pageable 객체를 반환합니다. 이를 사용하여 다음 페이지의 데이터를 검색할 수 있습니다.
			Pageable previousOrFirst(): 이전 페이지로 이동하거나 첫 번째 페이지로 이동하기 위한 Pageable 객체를 반환합니다.
			Pageable first(): 첫 번째 페이지로 이동하기 위한 Pageable 객체를 반환합니다.
			boolean hasPrevious(): 이전 페이지가 있는지 여부를 확인하는 데 사용됩니다
		 */
        int pageNumber = 1; // 요청 페이지 (0부터 시작)
        int pageSize = 10; // 페이지 당 게시물 수
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("groupno").ascending().and(Sort.by("step").ascending()));
        Page<Board> page = boardRepository.findAll(pageable);
        for (Board board : page) {
            System.out.println(board);
        }
        /*
		<< Page 객체에는 다음과 같은 주요 메서드 및 속성이 포함되어 있습니다. >>
		- Page 객체는 주로 데이터베이스 쿼리 결과의 한 페이지를 나타내며, 페이징된 데이터를 관리하고 검색 결과를 페이지별로 표시하는 데 사용됩니다.

		getContent(): 현재 페이지의 데이터를 나타내는 리스트나 컬렉션을 반환합니다.
		getNumber(): 현재 페이지 번호를 반환합니다. 페이지 번호는 0부터 시작합니다.
		getSize(): 한 페이지에 표시될 항목 수를 반환합니다.
		getTotalElements(): 전체 항목 수를 반환합니다. 이 값은 페이지네이션을 사용하여 검색된 항목의 총 수를 나타냅니다.
		getTotalPages(): 전체 페이지 수를 반환합니다. 페이지 수는 페이지당 항목 수와 전체 항목 수에 따라 결정됩니다.
		hasContent(): 페이지에 내용이 있는지 여부를 확인합니다.
		isEmpty(): 페이지가 비어 있는지 여부를 확인합니다.
		isFirst(): 현재 페이지가 첫 번째 페이지인지 여부를 확인합니다.
		isLast(): 현재 페이지가 마지막 페이지인지 여부를 확인합니다.
		hasNext(): 다음 페이지가 있는지 여부를 확인합니다.
		hasPrevious(): 이전 페이지가 있는지 여부를 확인합니다.
		getPageable(): 페이지네이션 및 정렬 정보가 포함된 Pageable 객체를 반환합니다.
		*/
        System.out.println("*******************결과***********************");
        System.out.println("현재 페이지 번호 [0 base index]	      	:" + page.getNumber());
        System.out.println("이전 페이지 번호 [0 base index]	      	:" + page.previousOrFirstPageable().getPageNumber());
        System.out.println("다음 페이지 번호 [0 base index]	      	:" + page.nextOrLastPageable().getPageNumber());

        System.out.println("한 페이지에 표시될 항목 수  	 		:" + page.getSize());
        System.out.println("전체 항목 수            		 		:" + page.getTotalElements());
        System.out.println("전체 페이지 수		     		 		:" + page.getTotalPages());
        System.out.println("현재 페이지가 첫 번째 페이지인지 여부 	:" + page.isFirst());
        System.out.println("현재 페이지가 마지막 페이지인지 여부  	:" + page.isLast());
        System.out.println("다음 페이지가 있는지 여부          		:" + page.hasNext());
        System.out.println("이전 페이지가 있는지 여부          		:" + page.hasPrevious());
        Pageable currentPageable = page.getPageable();
        System.out.println("페이지 시작 게시물 offset [0 base index] :" + currentPageable.getOffset());
        System.out.println("페이지   끝 게시물 offset [0 base index] :" + (currentPageable.getOffset() + page.getContent().size() - 1));
        System.out.println("페이지네이션 및 정렬 정보가 포함된 Pageable 객체를 반환:" + currentPageable.next());
        System.out.println("페이지네이션 및 정렬 정보가 포함된 Pageable 객체를 반환:" + currentPageable.next().next());
        System.out.println("페이지네이션 및 정렬 정보가 포함된 Pageable 객체를 반환:" + currentPageable.next().next().next());

        //페이지블록페이지수
        int BLOCK_SCALE = 5;
        //현재페이지블록번호
        int curBlock = (int) Math.ceil(page.getNumber() / BLOCK_SCALE) + 1;
        //페이지블록시작번호
        int blockBegin = (curBlock - 1) * BLOCK_SCALE + 1;
        //페이지블록끝번호
        int blockEnd = blockBegin + BLOCK_SCALE - 1;
        //이전그룹시작페이지번호
        int previousGroupStartPage = blockBegin - BLOCK_SCALE;
        //다음그룹시작페이지번호
        int nextGroupStartPage = blockBegin + BLOCK_SCALE;


        System.out.println("페이지 블록 페이지 수     :" + BLOCK_SCALE);
        System.out.println("현재 페이지 블록 번호     :" + curBlock);
        System.out.println("페이지 블록 시작 번호     :" + blockBegin);
        System.out.println("페이지 블록   끝 번호     :" + blockEnd);
        System.out.println("이전 그룹 시작 페이지 번호:" + previousGroupStartPage);
        System.out.println("다음 그룹 시작 페이지 번호:" + nextGroupStartPage);

    }
}