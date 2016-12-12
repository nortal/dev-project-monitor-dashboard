insert into notification (text, type) values ('This is a test info message', 'INFO');
insert into notification (text, type) values ('This is a test info message', 'WARNING');
insert into notification (text, type) values ('This is a test info message', 'ERROR');
insert into notification (text, type) values ('This is a test info message', 'MESSAGE');

insert into ping_info (module, status, status_detail, url, checked, last_responded)
    values ('Ok module', 'OK', 'This is OK', 'http://url1/health', current_timestamp, current_timestamp);
insert into ping_info (module, status, status_detail, url, checked, last_responded)
    values ('Error module', 'ERROR', 'This is ERROR', 'http://url2/health', current_timestamp, current_timestamp);
insert into ping_info (module, status, status_detail, url, checked, last_responded)
    values ('Timeout module', 'TIMEOUT', 'This is TIMEOUT', 'http://url3/health', current_timestamp, current_timestamp);