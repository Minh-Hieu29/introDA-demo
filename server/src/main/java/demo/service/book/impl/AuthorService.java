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
	private AuthorRepository AuthorRepository;
	
	@Autowired
	private AuthorConverter AuthorConverter;
	
	@Override
	public AuthorDTO save(AuthorDTO AuthorDTO) {
		AuthorEntity AuthorEntity = new AuthorEntity();
		if(AuthorDTO.getId() != 0) {
			AuthorEntity oldAuthorEntity = AuthorRepository.findById(AuthorDTO.getId()).get();
			AuthorEntity = AuthorConverter.toEntity(AuthorDTO, oldAuthorEntity);
		} else {
			AuthorEntity = AuthorConverter.toEntity(AuthorDTO);
		}
		AuthorEntity = AuthorRepository.save(AuthorEntity);
		return AuthorConverter.toDTO(AuthorEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			AuthorRepository.deleteById(item);
		}
		
	}

	@Override
	public List<AuthorDTO> findAll(Pageable pageable) {
		List<AuthorDTO> results = new ArrayList<>();
		List<AuthorEntity> entities = AuthorRepository.findAll(pageable).getContent();
		for(AuthorEntity item: entities) {
			AuthorDTO AuthorDTO = AuthorConverter.toDTO(item);
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
