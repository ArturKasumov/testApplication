/*Insert into travelAgency*/
insert into travel_agency  (id, name, description) values (1, 'BestAgency', 'Really best agency');
insert into travel_agency  (id, name, description) values (2, 'YourAgency', 'Travel with us');
insert into travel_agency  (id, name, description) values (3, 'JustAgency', 'Test');
insert into travel_agency  (id, name, description) values (4, 'UkraineAgency', 'Test');

/*Insert into Tour*/
insert into tour  (id, name, country, amount, travel_agency_id) values (1, 'toAfrica', 'Africa', 20, 1);
insert into tour  (id, name, country, amount, travel_agency_id) values (2, 'toVienna', 'Austria', 45, 1);
insert into tour  (id, name, country, amount, travel_agency_id) values (3, 'toMadagascar', 'Africa', 35, 2);
insert into tour  (id, name, country, amount, travel_agency_id) values (4, 'toKiev', 'Ukraine', 20, 3);

/*Insert into Booking*/
insert into booking  (full_name, amount_reserved_places, tour_id) values ('Иванов Иван Ивонович', 8, 1);
insert into booking  (full_name, amount_reserved_places, tour_id) values ('Петров Петр Петрович', 2, 2);
insert into booking  (full_name, amount_reserved_places, tour_id) values ('Димтриенко Дмитрий Дмитриевич', 3, 1);