package platform.businesslayer.service;

import platform.businesslayer.entity.Code;

import java.util.List;
import java.util.UUID;

public interface CodeSharingService {

    UUID createCode(final Code code);

    Code readCode(final UUID id) ;

    List<Code> readLatestCode(final int quantity) ;

    default List<Code> readLatestCode()  {
        return readLatestCode(10);
    }
}
