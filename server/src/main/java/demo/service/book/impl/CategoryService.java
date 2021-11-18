package demo.service.book.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import demo.converter.book.CategoryConverter;
import demo.dto.book.CategoryDTO;
import demo.entity.book.CategoryEntity;
import demo.repository.book.CategoryRepository;
import demo.service.book.CategoryServiceImpl;

@Service
public class CategoryService implements CategoryServiceImpl{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryConverter categoryConverter;
	
	@Override
	public CategoryDTO save(CategoryDTO categoryDTO) {
		CategoryEntity categoryEntity = new CategoryEntity();
		if(categoryDTO.getId() != 0) {
			CategoryEntity oldCategoryEntity = categoryRepository.findById(categoryDTO.getId()).get();
			categoryEntity = categoryConverter.toEntity(categoryDTO, oldCategoryEntity);
		} else {
			categoryEntity = categoryConverter.toEntity(categoryDTO);
		}
		categoryEntity = categoryRepository.save(categoryEntity);
		return categoryConverter.toDTO(categoryEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			categoryRepository.deleteById(item);
		}
		
	}

	@Override
	public List<CategoryDTO> findAll(Pageable pageable) {
		List<CategoryDTO> results = new ArrayList<>();
		List<CategoryEntity> entities = categoryRepository.findAll(pageable).getContent();
		for(CategoryEntity item: entities) {
			CategoryDTO categoryDTO = categoryConverter.toDTO(item);
			results.add(categoryDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

}
