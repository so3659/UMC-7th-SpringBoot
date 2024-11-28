package umc.study.springboot.addMission.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.springboot.addMission.converter.MissionConverter;
import umc.study.springboot.addMission.dto.MissionRequestDTO;
import umc.study.springboot.domain.Mission;
import umc.study.springboot.domain.Store;
import umc.study.springboot.repository.MissionRepository;
import umc.study.springboot.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;


    @Override
    @Transactional
    public Mission joinMission(MissionRequestDTO.JoinMissionDTO request, Long id){
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Store not found"));

        Mission newMission = MissionConverter.toMission(request);
        newMission.setStore(store);

        return missionRepository.save(newMission);
    }
}
