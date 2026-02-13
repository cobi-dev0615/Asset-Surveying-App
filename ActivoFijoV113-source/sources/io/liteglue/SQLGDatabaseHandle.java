package io.liteglue;

/* loaded from: classes.dex */
class SQLGDatabaseHandle implements SQLDatabaseHandle {
    String dbfilename;
    private long dbhandle = 0;
    int openflags;

    public SQLGDatabaseHandle(String str, int i) {
        this.dbfilename = null;
        this.openflags = 0;
        this.dbfilename = str;
        this.openflags = i;
    }

    @Override // io.liteglue.SQLDatabaseHandle
    public int open() {
        String str = this.dbfilename;
        if (str == null || this.dbhandle != 0) {
            return 21;
        }
        SQLiteNativeResponse sqlc_db_open = SQLiteNDKNativeDriver.sqlc_db_open(str, this.openflags);
        if (sqlc_db_open.getResult() != 0) {
            return -sqlc_db_open.getResult();
        }
        this.dbhandle = sqlc_db_open.getHandle();
        return 0;
    }

    @Override // io.liteglue.SQLDatabaseHandle
    public int close() {
        long j = this.dbhandle;
        if (j == 0) {
            return 21;
        }
        return SQLiteNDKNativeDriver.sqlc_db_close(j);
    }

    @Override // io.liteglue.SQLDatabaseHandle
    public boolean isOpen() {
        return this.dbhandle != 0;
    }

    @Override // io.liteglue.SQLDatabaseHandle
    public SQLStatementHandle newStatementHandle(String str) {
        if (this.dbhandle == 0) {
            return null;
        }
        return new SQLGStatementHandle(str);
    }

    @Override // io.liteglue.SQLDatabaseHandle
    public long getLastInsertRowid() {
        long j = this.dbhandle;
        if (j == 0) {
            return -1L;
        }
        return SQLiteNDKNativeDriver.sqlc_db_last_insert_rowid(j);
    }

    @Override // io.liteglue.SQLDatabaseHandle
    public int getTotalChanges() {
        long j = this.dbhandle;
        if (j == 0) {
            return -1;
        }
        return SQLiteNDKNativeDriver.sqlc_db_total_changes(j);
    }

    @Override // io.liteglue.SQLDatabaseHandle
    public String getLastErrorMessage() {
        long j = this.dbhandle;
        if (j == 0) {
            return null;
        }
        return SQLiteNDKNativeDriver.sqlc_db_errmsg_native(j);
    }

    private class SQLGStatementHandle implements SQLStatementHandle {
        String sql;
        private long sthandle;

        private SQLGStatementHandle(String str) {
            this.sql = null;
            this.sthandle = 0L;
            this.sql = str;
        }

        @Override // io.liteglue.SQLStatementHandle
        public int prepare() {
            if (this.sql == null || this.sthandle != 0) {
                return 21;
            }
            SQLiteNativeResponse sqlc_db_prepare_st = SQLiteNDKNativeDriver.sqlc_db_prepare_st(SQLGDatabaseHandle.this.dbhandle, this.sql);
            if (sqlc_db_prepare_st.getResult() != 0) {
                return -sqlc_db_prepare_st.getResult();
            }
            this.sthandle = sqlc_db_prepare_st.getHandle();
            return 0;
        }

        @Override // io.liteglue.SQLStatementHandle
        public int bindDouble(int i, double d) {
            long j = this.sthandle;
            if (j == 0) {
                return 21;
            }
            return SQLiteNDKNativeDriver.sqlc_st_bind_double(j, i, d);
        }

        @Override // io.liteglue.SQLStatementHandle
        public int bindInteger(int i, int i2) {
            long j = this.sthandle;
            if (j == 0) {
                return 21;
            }
            return SQLiteNDKNativeDriver.sqlc_st_bind_int(j, i, i2);
        }

        @Override // io.liteglue.SQLStatementHandle
        public int bindLong(int i, long j) {
            long j2 = this.sthandle;
            if (j2 == 0) {
                return 21;
            }
            return SQLiteNDKNativeDriver.sqlc_st_bind_long(j2, i, j);
        }

        @Override // io.liteglue.SQLStatementHandle
        public int bindNull(int i) {
            long j = this.sthandle;
            if (j == 0) {
                return 21;
            }
            return SQLiteNDKNativeDriver.sqlc_st_bind_null(j, i);
        }

        @Override // io.liteglue.SQLStatementHandle
        public int bindTextNativeString(int i, String str) {
            long j = this.sthandle;
            if (j == 0) {
                return 21;
            }
            return SQLiteNDKNativeDriver.sqlc_st_bind_text_native(j, i, str);
        }

        @Override // io.liteglue.SQLStatementHandle
        public int step() {
            long j = this.sthandle;
            if (j == 0) {
                return 21;
            }
            return SQLiteNDKNativeDriver.sqlc_st_step(j);
        }

        @Override // io.liteglue.SQLStatementHandle
        public int getColumnCount() {
            long j = this.sthandle;
            if (j == 0) {
                return -1;
            }
            return SQLiteNDKNativeDriver.sqlc_st_column_count(j);
        }

        @Override // io.liteglue.SQLStatementHandle
        public String getColumnName(int i) {
            long j = this.sthandle;
            if (j == 0) {
                return null;
            }
            return SQLiteNDKNativeDriver.sqlc_st_column_name(j, i);
        }

        @Override // io.liteglue.SQLStatementHandle
        public int getColumnType(int i) {
            long j = this.sthandle;
            if (j == 0) {
                return -1;
            }
            return SQLiteNDKNativeDriver.sqlc_st_column_type(j, i);
        }

        @Override // io.liteglue.SQLStatementHandle
        public double getColumnDouble(int i) {
            long j = this.sthandle;
            if (j == 0) {
                return -1.0d;
            }
            return SQLiteNDKNativeDriver.sqlc_st_column_double(j, i);
        }

        @Override // io.liteglue.SQLStatementHandle
        public int getColumnInteger(int i) {
            long j = this.sthandle;
            if (j == 0) {
                return -1;
            }
            return SQLiteNDKNativeDriver.sqlc_st_column_int(j, i);
        }

        @Override // io.liteglue.SQLStatementHandle
        public long getColumnLong(int i) {
            long j = this.sthandle;
            if (j == 0) {
                return -1L;
            }
            return SQLiteNDKNativeDriver.sqlc_st_column_long(j, i);
        }

        @Override // io.liteglue.SQLStatementHandle
        public String getColumnTextNativeString(int i) {
            long j = this.sthandle;
            if (j == 0) {
                return null;
            }
            return SQLiteNDKNativeDriver.sqlc_st_column_text_native(j, i);
        }

        @Override // io.liteglue.SQLStatementHandle
        public int finish() {
            long j = this.sthandle;
            if (j == 0) {
                return 21;
            }
            this.sql = null;
            this.sthandle = 0L;
            return SQLiteNDKNativeDriver.sqlc_st_finish(j);
        }
    }
}
