CREATE OR REPLACE VIEW PUBLIC.V_COURT_SEARCH AS 
SELECT 
    C_ID, 
    C_CODE, 
    C_NAME, 
    CONCAT_WS(' ', UPPER(C_CODE), UPPER(C_NAME)) AS C_SEARCH 
FROM PUBLIC.T_COURT;