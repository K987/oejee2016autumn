GRANT SELECT, INSERT, UPDATE, DELETE ON 
	anglerregistry.hal,
	anglerregistry.horgasz, 
	anglerregistry.horgaszto, 
	anglerregistry.telepites, 
	anglerregistry.engedely,
	anglerregistry.fogasinaplo
TO anglerregistry_role;
    
GRANT USAGE, SELECT, UPDATE ON anglerregistry.hal_id_seq TO anglerregistry_role;
GRANT USAGE, SELECT, UPDATE ON anglerregistry.horgasz_id_seq TO anglerregistry_role;
GRANT USAGE, SELECT, UPDATE ON anglerregistry.horgaszto_id_seq TO anglerregistry_role;
GRANT USAGE, SELECT, UPDATE ON anglerregistry.telepites_id_seq TO anglerregistry_role;
GRANT USAGE, SELECT, UPDATE ON anglerregistry.engedely_id_seq TO anglerregistry_role;
GRANT USAGE, SELECT, UPDATE ON anglerregistry.fogasinaplo_id_seq TO anglerregistry_role;