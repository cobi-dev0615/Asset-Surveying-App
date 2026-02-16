package io.liteglue;

import java.sql.SQLException;

/* loaded from: classes.dex */
class SQLiteGlueConnection implements SQLiteConnection {
    private SQLDatabaseHandle db;

    public SQLiteGlueConnection(String str, int i) throws SQLException {
        this.db = null;
        if (str == null) {
            throw new SQLException("null argument", "failed", 21);
        }
        SQLGDatabaseHandle sQLGDatabaseHandle = new SQLGDatabaseHandle(str, i);
        int open = sQLGDatabaseHandle.open();
        if (open != 0) {
            throw new SQLException("sqlite3_open_v2 failure: " + sQLGDatabaseHandle.getLastErrorMessage(), "failure", open);
        }
        this.db = sQLGDatabaseHandle;
    }

    @Override // io.liteglue.SQLiteConnection
    public void dispose() throws SQLException {
        SQLDatabaseHandle sQLDatabaseHandle = this.db;
        if (sQLDatabaseHandle == null) {
            throw new SQLException("already disposed", "failed", 21);
        }
        int close = sQLDatabaseHandle.close();
        if (close != 0) {
            throw new SQLException("sqlite3_close failure: " + this.db.getLastErrorMessage(), "failure", close);
        }
        this.db = null;
    }

    @Override // io.liteglue.SQLiteConnection
    public SQLiteStatement prepareStatement(String str) throws SQLException {
        if (this.db == null) {
            throw new SQLException("already disposed", "failed", 21);
        }
        if (str == null) {
            throw new SQLException("null argument", "failed", 21);
        }
        SQLGStatement sQLGStatement = new SQLGStatement(str);
        int prepare = sQLGStatement.prepare();
        if (prepare == 0) {
            return sQLGStatement;
        }
        throw new SQLException("sqlite3_prepare_v2 failure: " + this.db.getLastErrorMessage(), "failure", prepare);
    }

    @Override // io.liteglue.SQLiteConnection
    public long getLastInsertRowid() throws SQLException {
        SQLDatabaseHandle sQLDatabaseHandle = this.db;
        if (sQLDatabaseHandle == null) {
            throw new SQLException("already disposed", "failed", 21);
        }
        return sQLDatabaseHandle.getLastInsertRowid();
    }

    @Override // io.liteglue.SQLiteConnection
    public int getTotalChanges() throws SQLException {
        SQLDatabaseHandle sQLDatabaseHandle = this.db;
        if (sQLDatabaseHandle == null) {
            throw new SQLException("already disposed", "failed", 21);
        }
        return sQLDatabaseHandle.getTotalChanges();
    }

    private class SQLGStatement implements SQLiteStatement {
        private String sql;
        private SQLStatementHandle sthandle;
        private boolean hasRow = false;
        private int columnCount = 0;

        SQLGStatement(String str) {
            this.sthandle = null;
            this.sql = null;
            this.sql = str;
            this.sthandle = SQLiteGlueConnection.this.db.newStatementHandle(str);
        }

        int prepare() {
            return this.sthandle.prepare();
        }

        @Override // io.liteglue.SQLiteStatement
        public void bindDouble(int i, double d) throws SQLException {
            SQLStatementHandle sQLStatementHandle = this.sthandle;
            if (sQLStatementHandle == null) {
                throw new SQLException("already disposed", "failed", 21);
            }
            int bindDouble = sQLStatementHandle.bindDouble(i, d);
            if (bindDouble == 0) {
                return;
            }
            throw new SQLException("sqlite3_bind_double failure: " + SQLiteGlueConnection.this.db.getLastErrorMessage(), "failure", bindDouble);
        }

        @Override // io.liteglue.SQLiteStatement
        public void bindInteger(int i, int i2) throws SQLException {
            SQLStatementHandle sQLStatementHandle = this.sthandle;
            if (sQLStatementHandle == null) {
                throw new SQLException("already disposed", "failed", 21);
            }
            int bindInteger = sQLStatementHandle.bindInteger(i, i2);
            if (bindInteger == 0) {
                return;
            }
            throw new SQLException("sqlite3_bind_int failure: " + SQLiteGlueConnection.this.db.getLastErrorMessage(), "failure", bindInteger);
        }

        @Override // io.liteglue.SQLiteStatement
        public void bindLong(int i, long j) throws SQLException {
            SQLStatementHandle sQLStatementHandle = this.sthandle;
            if (sQLStatementHandle == null) {
                throw new SQLException("already disposed", "failed", 21);
            }
            int bindLong = sQLStatementHandle.bindLong(i, j);
            if (bindLong == 0) {
                return;
            }
            throw new SQLException("sqlite3_bind_int64 (long) failure: " + SQLiteGlueConnection.this.db.getLastErrorMessage(), "failure", bindLong);
        }

        @Override // io.liteglue.SQLiteStatement
        public void bindNull(int i) throws SQLException {
            SQLStatementHandle sQLStatementHandle = this.sthandle;
            if (sQLStatementHandle == null) {
                throw new SQLException("already disposed", "failed", 21);
            }
            int bindNull = sQLStatementHandle.bindNull(i);
            if (bindNull == 0) {
                return;
            }
            throw new SQLException("sqlite3_bind_null failure: " + SQLiteGlueConnection.this.db.getLastErrorMessage(), "failure", bindNull);
        }

        @Override // io.liteglue.SQLiteStatement
        public void bindTextNativeString(int i, String str) throws SQLException {
            SQLStatementHandle sQLStatementHandle = this.sthandle;
            if (sQLStatementHandle == null) {
                throw new SQLException("already disposed", "failed", 21);
            }
            if (str == null) {
                throw new SQLException("null argument", "failed", 21);
            }
            int bindTextNativeString = sQLStatementHandle.bindTextNativeString(i, str);
            if (bindTextNativeString == 0) {
                return;
            }
            throw new SQLException("sqlite3_bind_text failure: " + SQLiteGlueConnection.this.db.getLastErrorMessage(), "failure", bindTextNativeString);
        }

        @Override // io.liteglue.SQLiteStatement
        public boolean step() throws SQLException {
            SQLStatementHandle sQLStatementHandle = this.sthandle;
            if (sQLStatementHandle == null) {
                throw new SQLException("already disposed", "failed", 21);
            }
            int step = sQLStatementHandle.step();
            if (step != 0 && step != 100 && step != 101) {
                throw new SQLException("sqlite3_step failure: " + SQLiteGlueConnection.this.db.getLastErrorMessage(), "failure", step);
            }
            boolean z = step == 100;
            this.hasRow = z;
            if (z) {
                this.columnCount = this.sthandle.getColumnCount();
            } else {
                this.columnCount = 0;
            }
            return this.hasRow;
        }

        @Override // io.liteglue.SQLiteStatement
        public int getColumnCount() throws SQLException {
            if (this.sthandle == null) {
                throw new SQLException("already disposed", "failed", 21);
            }
            if (!this.hasRow) {
                throw new SQLException("no result available", "failed", 21);
            }
            return this.columnCount;
        }

        @Override // io.liteglue.SQLiteStatement
        public String getColumnName(int i) throws SQLException {
            SQLStatementHandle sQLStatementHandle = this.sthandle;
            if (sQLStatementHandle == null) {
                throw new SQLException("already disposed", "failed", 21);
            }
            if (!this.hasRow) {
                throw new SQLException("no result available", "failed", 21);
            }
            if (i < 0 || i >= this.columnCount) {
                throw new SQLException("no result available", "failed", 21);
            }
            return sQLStatementHandle.getColumnName(i);
        }

        @Override // io.liteglue.SQLiteStatement
        public int getColumnType(int i) throws SQLException {
            SQLStatementHandle sQLStatementHandle = this.sthandle;
            if (sQLStatementHandle == null) {
                throw new SQLException("already disposed", "failed", 21);
            }
            if (!this.hasRow) {
                throw new SQLException("no result available", "failed", 21);
            }
            if (i < 0 || i >= this.columnCount) {
                throw new SQLException("no result available", "failed", 21);
            }
            return sQLStatementHandle.getColumnType(i);
        }

        @Override // io.liteglue.SQLiteStatement
        public double getColumnDouble(int i) throws SQLException {
            SQLStatementHandle sQLStatementHandle = this.sthandle;
            if (sQLStatementHandle == null) {
                throw new SQLException("already disposed", "failed", 21);
            }
            if (!this.hasRow) {
                throw new SQLException("no result available", "failed", 21);
            }
            if (i < 0 || i >= this.columnCount) {
                throw new SQLException("no result available", "failed", 21);
            }
            return sQLStatementHandle.getColumnDouble(i);
        }

        @Override // io.liteglue.SQLiteStatement
        public int getColumnInteger(int i) throws SQLException {
            SQLStatementHandle sQLStatementHandle = this.sthandle;
            if (sQLStatementHandle == null) {
                throw new SQLException("already disposed", "failed", 21);
            }
            if (!this.hasRow) {
                throw new SQLException("no result available", "failed", 21);
            }
            if (i < 0 || i >= this.columnCount) {
                throw new SQLException("no result available", "failed", 21);
            }
            return sQLStatementHandle.getColumnInteger(i);
        }

        @Override // io.liteglue.SQLiteStatement
        public long getColumnLong(int i) throws SQLException {
            SQLStatementHandle sQLStatementHandle = this.sthandle;
            if (sQLStatementHandle == null) {
                throw new SQLException("already disposed", "failed", 21);
            }
            if (!this.hasRow) {
                throw new SQLException("no result available", "failed", 21);
            }
            if (i < 0 || i >= this.columnCount) {
                throw new SQLException("no result available", "failed", 21);
            }
            return sQLStatementHandle.getColumnLong(i);
        }

        @Override // io.liteglue.SQLiteStatement
        public String getColumnTextNativeString(int i) throws SQLException {
            SQLStatementHandle sQLStatementHandle = this.sthandle;
            if (sQLStatementHandle == null) {
                throw new SQLException("already disposed", "failed", 21);
            }
            if (!this.hasRow) {
                throw new SQLException("no result available", "failed", 21);
            }
            if (i < 0 || i >= this.columnCount) {
                throw new SQLException("no result available", "failed", 21);
            }
            return sQLStatementHandle.getColumnTextNativeString(i);
        }

        @Override // io.liteglue.SQLiteStatement
        public void dispose() throws SQLException {
            SQLStatementHandle sQLStatementHandle = this.sthandle;
            if (sQLStatementHandle == null) {
                throw new SQLException("already disposed", "failed", 21);
            }
            sQLStatementHandle.finish();
            this.sthandle = null;
        }
    }
}
