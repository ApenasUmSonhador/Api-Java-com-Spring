alter table medics add active tinyint;
update medics set active = 1;

alter table patients add active tinyint;
update patients set active = 1;