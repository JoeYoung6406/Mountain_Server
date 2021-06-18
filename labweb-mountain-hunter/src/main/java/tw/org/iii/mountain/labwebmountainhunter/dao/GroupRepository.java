package tw.org.iii.mountain.labwebmountainhunter.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.org.iii.mountain.labwebmountainhunter.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Integer> {

	Group findByName(String name);

}
