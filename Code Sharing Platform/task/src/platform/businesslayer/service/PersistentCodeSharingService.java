package platform.businesslayer.service;

import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import platform.businesslayer.entity.Code;
import platform.businesslayer.exception.CodeNotFoundException;
import platform.persistance.repository.CodeCrudRepository;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

@Primary
@Service
public class PersistentCodeSharingService implements CodeSharingService {

    private final CodeCrudRepository codeCrudRepository;
    private final ThreadPoolTaskExecutor executor;

    public PersistentCodeSharingService(final CodeCrudRepository codeCrudRepository, final ThreadPoolTaskExecutor executor) {
        this.codeCrudRepository = codeCrudRepository;
        this.executor = executor;
    }

    @Override
    public UUID createCode(final Code code) {
        var savedCode = codeCrudRepository.save(code);
        var savedCodeTime = savedCode.getTime();

        if (savedCodeTime != null) {
            executor.execute(() -> {
                try {
                    Thread.sleep(savedCodeTime * 1000);
                    codeCrudRepository.delete(savedCode);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        return savedCode.getId();
    }

    @Override
    public Code readCode(final UUID id) {
        var optionalCode = codeCrudRepository.findById(id);
        if (optionalCode.isEmpty()) {
            throw new CodeNotFoundException(id);
        }
        var code = optionalCode.get();

        var codeViews = code.getViews();
        if (codeViews != null) {
            var codeTotalViews = code.getTotalViews() + 1;
            code.setTotalViews(codeTotalViews);
            if (codeViews == codeTotalViews) {
                codeCrudRepository.delete(code);
            } else {
                codeCrudRepository.save(code);
            }
        }
        return code;
    }

    // FIXME: this implementation breaks if enough entries will be in DB
    @Override
    public List<Code> readLatestCode(final int quantity) {
        List<Code> codes = new ArrayList<>();
        codeCrudRepository.findAll().forEach(codes::add);
        codes.sort((o1, o2) -> -o1.getDate().compareTo(o2.getDate()));
        codes = codes.stream()
                .filter((code) -> code.getViews() == null && code.getTime() == null)
                .limit(Math.min(quantity, codes.size()))
                .collect(Collectors.toList());
        return codes;
    }

    // TODO: add delete scheduling after startup
}
