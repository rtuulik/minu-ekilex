insert into label_type (code, value) values ('capital', 'capital');
insert into label_type (code, value) values ('abbrev', 'abbrev');
insert into label_type (code, value) values ('ekimorfo', 'ekimorfo');
insert into label_type (code, value) values ('descrip', 'descrip');
insert into label_type (code, value) values ('descrip2', 'descrip2');
insert into label_type (code, value) values ('full', 'full');
insert into label_type (code, value) values ('wordweb', 'wordweb');
insert into label_type (code, value) values ('iso2', 'iso2');

-- lex
insert into dataset (code, type, name, is_visible, is_public) values ('ss1', 'LEX', 'Eesti keele sõnaraamat 2019', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('psv', 'LEX', 'Eesti keele põhisõnavara sõnastik 2019', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('ety', 'LEX', 'Etümoloogia', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('qq2', 'LEX', 'Eesti-vene õpilase ÕS 2019', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('ev2', 'LEX', 'Eesti-vene sõnaraamat 2019', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('kol', 'LEX', 'Eesti keele naabersõnad 2019', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('mab', 'LEX', 'Eesti keele morfoloogia', false, false);

insert into dataset (code, type, name, is_visible, is_public) values ('sss', 'LEX', 'Supersõnaraamat 2019', true, true);

-- term
insert into dataset (code, type, name, is_visible, is_public) values ('est', 'TERM', 'Esterm', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('mil', 'TERM', 'Militerm', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('aia', 'TERM', 'Aiandus (aiandusterminoloogia sõnastik)', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('ait', 'TERM', 'Aianduse terminibaas (2017)', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('avt', 'TERM', 'Akadeemilise väljendusoskuse terminid', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('aso', 'TERM', 'Andmeanalüüsi ja statistika oskussõnastik', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('arh', 'TERM', 'Arheoloogia terminibaas', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('aos', 'TERM', 'Arhitektuuri oskussõnastik', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('den', 'TERM', 'Dental Technique Terminology', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('eõt', 'TERM', 'E-õppe termineid', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('ett', 'TERM', 'Eesti E-tervise SA terminibaas', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('õtb', 'TERM', 'Eesti-vene-eesti õigusterminoloogiabaas', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('ent', 'TERM', 'Entomoloogia', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('fil', 'TERM', 'Filosoofia', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('fkm', 'TERM', 'Filmikunsti mõisted', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('fon', 'TERM', 'Foneetika', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('gen', 'TERM', 'Geneetika terminibaas', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('get', 'TERM', 'Geoloogia', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('gmt', 'TERM', 'Geomorfoloogia', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('ida', 'TERM', 'Ida mõtteloo leksikon', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('iht', 'TERM', 'Ihtüoloogia', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('imm', 'TERM', 'Immunoloogia', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('bks', 'TERM', 'Inglise-eesti biokeemia sõnastik', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('kto', 'TERM', 'Käsitööteaduse oskussõnad', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('kem', 'TERM', 'Keemiatermite baas', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('kkt', 'TERM', 'Kognitiivse keeleteaduse terminibaas', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('kok', 'TERM', 'Kokandus', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('kfs', 'TERM', 'Küberfüüsikalise süsteemitehnika terminibaas', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('lim', 'TERM', 'Limnoloogia sõnastik', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('lkt', 'TERM', 'Loomakasvatus', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('lon', 'TERM', 'Loomanimed', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('pre', 'TERM', 'Loomaparasiitide eestipärased nimetused', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('lpr', 'TERM', 'Loomaparasiitide nimistu', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('lko', 'TERM', 'Loomi kaasavate organisatsioonide terminibaas', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('les', 'TERM', 'Läti-eesti sõnastik', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('mef', 'TERM', 'Meditsiinifüüsika', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('mes', 'TERM', 'Mesindusleksikon', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('met', 'TERM', 'MetalliAabits', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('mea', 'TERM', 'Metroloogia', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('mon', 'TERM', 'Montessori pedagoogika terminivara', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('mut', 'TERM', 'Muuseumiterminoloogia', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('mte', 'TERM', 'Muusikateraapia seletav sõnastik', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('mtr', 'TERM', 'Materjalitehnika', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('nht', 'TERM', 'Nahkhiirte-alased terminid', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('prs', 'TERM', 'Parasitoloogia terminid', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('plt', 'TERM', 'Põllumajandusloomade tõud', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('pot', 'TERM', 'Patsiendiohutuse terminibaas', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('pol', 'TERM', 'Poliitika ja valitsemise sõnastik', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('pur', 'TERM', 'Purjetamise terminoloogia', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('p3m', 'TERM', 'P3M (Projektide, programmide ja portfellide juhtimise mõistete baas)', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('rkb', 'TERM', 'Rakubioloogia', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('rob', 'TERM', 'Robootika', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('skt', 'TERM', 'Skeemiteraapiasõnastik', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('tet', 'TERM', 'Teatriterminoloogia', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('tee', 'TERM', 'Teenuste valdkonna terminibaas', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('tts', 'TERM', 'Tootmistehnika ja süsteemide terminibaas', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('usk', 'TERM', 'Uskumusolendite sõnastik', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('ust', 'TERM', 'Usterm', true, true);
insert into dataset (code, type, name, is_visible, is_public) values ('vlk', 'TERM', 'Veterinaarmeditsiin ja loomakasvatus', true, true);
