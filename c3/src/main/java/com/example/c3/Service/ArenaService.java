package com.example.c3.Service;

import com.example.c3.ApiResponse.ApiException;
import com.example.c3.DTO.ArenaDTO;
import com.example.c3.Model.Arena;
import com.example.c3.Repository.ArenaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArenaService {
    // 1. Declare a dependency for ArenaRepository using Dependency Injection
    private final ArenaRepository arenaRepository;

    public List<Arena> getAllArenas() {
        return arenaRepository.findAll();
    }
    // 2. CRUD
    // 2.1 GET
//    public List<ArenaDTO> getAllArenas() {
//        List<Arena> arenas = arenaRepository.findAll();
//        List<ArenaDTO> arenaDTOS = new ArrayList<>();
//        for (Arena arena : arenas) {
//            ArenaDTO arenaDTO = new ArenaDTO(arena.getName(),arena.getCity(),arena.getLocation(),arena.getServices(),arena.getEvents());
//            arenaDTOS.add(arenaDTO);
//        }
//        return arenaDTOS;
//    }

    // 2.2 POST
    public void addArena(Arena arena) {
        arenaRepository.save(arena);
    }

    // 2.3 UPDATE
    public void updateArena(Integer id, Arena arena) {
        Arena oldArena = arenaRepository.findArenaById(id);
        if (oldArena == null) {
            throw new ApiException("Arena Not Found.");
        }
        oldArena.setName(arena.getName());
        oldArena.setCity(arena.getCity());
        oldArena.setLocation(arena.getLocation());
        oldArena.setLicense(arena.getLicense());
        oldArena.setLicenseEndDate(arena.getLicenseEndDate());
        arenaRepository.save(oldArena);
    }

    // 2.4 DELETE
    public void deleteArena(Integer id) {
        Arena oldArena = arenaRepository.findArenaById(id);
        if (oldArena == null) {
            throw new ApiException("Arena Not Found.");
        }
        arenaRepository.delete(oldArena);
    }
}