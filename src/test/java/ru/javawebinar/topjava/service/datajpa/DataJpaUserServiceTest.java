package ru.javawebinar.topjava.service.datajpa;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.service.AbstractUserServiceTest;

@ActiveProfiles({Profiles.HSQL_DB, Profiles.DATAJPA})
public class DataJpaUserServiceTest extends AbstractUserServiceTest {
}
