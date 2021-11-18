package demo.service.book.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import demo.converter.book.AuthorConverter;
import demo.dto.book.AuthorDTO;
import demo.entity.book.AuthorEntity;
import demo.repository.book.AuthorRepository;
import demo.service.book.AuthorServiceImpl;

@Service
public class AuthorService implements AuthorServiceImpl{

	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private AuthorConverter authorConverter;
	
	
	@Override
	public AuthorDTO save(AuthorDTO AuthorDTO) {
		AuthorEntity authorEntity = new AuthorEntity();
		if(AuthorDTO.getId() != 0) {
			AuthorEntity oldAuthorEntity = authorRepository.findById(AuthorDTO.getId()).get();
			authorEntity = authorConverter.toEntity(AuthorDTO, oldAuthorEntity);
		} else {
			authorEntity = authorConverter.toEntity(AuthorDTO);
		}
		authorEntity = authorRepository.save(authorEntity);
		return authorConverter.toDTO(authorEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			authorRepository.deleteById(item);
		}
		
	}

	@Override
	public List<AuthorDTO> findAll(Pageable pageable) {
		List<AuthorDTO> results = new ArrayList<>();
		List<AuthorEntity> entities = authorRepository.findAll(pageable).getContent();
		for(AuthorEntity item: entities) {
			AuthorDTO AuthorDTO = authorConverter.toDTO(item);
			results.add(AuthorDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

}
