package com.deezer.artist;

import com.deezer.artist.mapper.response.ArtistEntityResponseMapper;
import com.deezer.artist.mapper.response.ArtistIntegrationResponseMapper;
import com.deezer.artist.model.response.ArtistIntegrationResponse;
import com.deezer.artist.model.response.ArtistServiceResponse;
import com.deezer.exceptions.datanotfound.DataNotFoundException;
import com.deezer.repository.ArtistRepository;
import com.deezer.repository.entity.ArtistEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;
import java.util.function.Function;

@AllArgsConstructor
@Service
public class ArtistService {
    private final ArtistIntegration artistIntegration;
    private final ArtistRepository artistRepository;

    public Optional<ArtistEntity> findArtistById(String id) {
        return artistRepository.findById(id);
    }

    public ArtistServiceResponse findArtistIntegration(String id) {
        return Optional.of(artistIntegration.findArtist(id))
                .map(artistValidation())
                .map(ArtistIntegrationResponseMapper::toIntegrationResponse)
                .map(artistRepository::save)
                .map(ArtistEntityResponseMapper::toArtistEntity)
                .orElseThrow(() -> new DataNotFoundException("id"));
    }

    private Function<ArtistIntegrationResponse, ArtistIntegrationResponse> artistValidation() {
        return artist -> {
            if(ObjectUtils.isEmpty(artist.getName())){
                throw new DataNotFoundException("id");
            }
            return artist;
        };
    }

    public void deleteArtist(String id) {
        artistRepository.deleteById(id);
    }
}
