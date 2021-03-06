IF NOT EXISTS (SELECT * FROM sys.database_principals WHERE name = N'whrc')
CREATE USER [whrc] WITHOUT LOGIN WITH DEFAULT_SCHEMA=[dbo]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_system_admin_log]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_system_admin_log](
	[LogID] [int] IDENTITY(1,1) NOT NULL,
	[AdminName] [varchar](50) NULL,
	[Type] [int] NULL,
	[Content] [varchar](2000) NULL,
	[AddTime] [datetime] NULL,
	[IP] [varchar](50) NULL,
 CONSTRAINT [PK_T_SYSTEM_ADMIN_LOG] PRIMARY KEY NONCLUSTERED 
(
	[LogID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'人员日志编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin_log', @level2type=N'COLUMN', @level2name=N'LogID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'帐号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin_log', @level2type=N'COLUMN', @level2name=N'AdminName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'日志类型：1-操作日志、2-登录日志' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin_log', @level2type=N'COLUMN', @level2name=N'Type'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'日志内容' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin_log', @level2type=N'COLUMN', @level2name=N'Content'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'日志时间' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin_log', @level2type=N'COLUMN', @level2name=N'AddTime'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'日志IP' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin_log', @level2type=N'COLUMN', @level2name=N'IP'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'管理人员日志表' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin_log'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_post]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_post](
	[TitledatabaseID] [int] IDENTITY(1,1) NOT NULL,
	[TitleID] [int] NOT NULL,
	[TitleName] [varchar](50) NOT NULL,
	[Description] [varchar](500) NOT NULL,
	[FartherTitleID] [int] NOT NULL,
	[Depth] [int] NOT NULL,
	[Is_Del] [int] NULL,
 CONSTRAINT [PK_T_POST] PRIMARY KEY NONCLUSTERED 
(
	[TitledatabaseID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [unq_post] UNIQUE NONCLUSTERED 
(
	[TitleID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'职称编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_post', @level2type=N'COLUMN', @level2name=N'TitleID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'职称名称' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_post', @level2type=N'COLUMN', @level2name=N'TitleName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'职称描述' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_post', @level2type=N'COLUMN', @level2name=N'Description'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'上级职称编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_post', @level2type=N'COLUMN', @level2name=N'FartherTitleID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'深度' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_post', @level2type=N'COLUMN', @level2name=N'Depth'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'是否删除：1-未删除、2-已删除' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_post', @level2type=N'COLUMN', @level2name=N'Is_Del'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'职称表' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_post'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_proadd]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_proadd](
	[ProadddatabaseID] [int] IDENTITY(1,1) NOT NULL,
	[ProaddID] [int] NOT NULL,
	[ProaddName] [varchar](50) NOT NULL,
 CONSTRAINT [PK_t_proadd] PRIMARY KEY NONCLUSTERED 
(
	[ProadddatabaseID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'数据库ID' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_proadd', @level2type=N'COLUMN', @level2name=N'ProadddatabaseID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'地址ID' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_proadd', @level2type=N'COLUMN', @level2name=N'ProaddID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'地址名称' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_proadd', @level2type=N'COLUMN', @level2name=N'ProaddName'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_profession]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_profession](
	[BusinessdatabaseID] [int] IDENTITY(1,1) NOT NULL,
	[BusinessTypeID] [int] NOT NULL,
	[BusinessTypeName] [varchar](50) NOT NULL,
 CONSTRAINT [PK_t_profession] PRIMARY KEY NONCLUSTERED 
(
	[BusinessdatabaseID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'数据库ID' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_profession', @level2type=N'COLUMN', @level2name=N'BusinessdatabaseID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'企业所属行业ID' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_profession', @level2type=N'COLUMN', @level2name=N'BusinessTypeID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'企业行业类型名称' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_profession', @level2type=N'COLUMN', @level2name=N'BusinessTypeName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'行业类别表' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_profession'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_project_quality]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_project_quality](
	[proqulidatabaseID] [int] IDENTITY(1,1) NOT NULL,
	[proquliID] [int] NOT NULL,
	[proquliName] [varchar](50) NOT NULL,
 CONSTRAINT [PK_t_project_quality] PRIMARY KEY NONCLUSTERED 
(
	[proqulidatabaseID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'数据库ID' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_project_quality', @level2type=N'COLUMN', @level2name=N'proqulidatabaseID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'项目性质ID' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_project_quality', @level2type=N'COLUMN', @level2name=N'proquliID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'项目性质Name' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_project_quality', @level2type=N'COLUMN', @level2name=N'proquliName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'项目性质' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_project_quality'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_projectpic]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_projectpic](
	[ProjectPicID] [int] IDENTITY(1,1) NOT NULL,
	[DatabaseProjectID] [int] NOT NULL,
	[Pic] [varchar](100) NOT NULL,
 CONSTRAINT [PK_T_PROJECTPIC] PRIMARY KEY CLUSTERED 
(
	[ProjectPicID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'项目图片编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_projectpic', @level2type=N'COLUMN', @level2name=N'ProjectPicID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'项目编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_projectpic', @level2type=N'COLUMN', @level2name=N'DatabaseProjectID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'项目图片' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_projectpic', @level2type=N'COLUMN', @level2name=N'Pic'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'项目图片表' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_projectpic'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_regions]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_regions](
	[RegiondatabaseID] [int] IDENTITY(1,1) NOT NULL,
	[RegionID] [int] NOT NULL,
	[RegionName] [varchar](50) NOT NULL,
	[PartherRegionsID] [int] NOT NULL,
	[Depth] [int] NOT NULL,
 CONSTRAINT [PK_T_REGIONS] PRIMARY KEY NONCLUSTERED 
(
	[RegiondatabaseID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [unq_regionID] UNIQUE NONCLUSTERED 
(
	[RegionID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'城市编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_regions', @level2type=N'COLUMN', @level2name=N'RegionID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'城市名称' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_regions', @level2type=N'COLUMN', @level2name=N'RegionName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'上级城市编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_regions', @level2type=N'COLUMN', @level2name=N'PartherRegionsID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'深度' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_regions', @level2type=N'COLUMN', @level2name=N'Depth'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'郑州市地区表' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_regions'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_shb]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_shb](
	[shbdatabaseID] [int] IDENTITY(1,1) NOT NULL,
	[shbID] [int] NOT NULL,
	[shbName] [varchar](50) NOT NULL,
 CONSTRAINT [PK_t_shb] PRIMARY KEY NONCLUSTERED 
(
	[shbdatabaseID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'数据库ID' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_shb', @level2type=N'COLUMN', @level2name=N'shbdatabaseID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'审核备ID' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_shb', @level2type=N'COLUMN', @level2name=N'shbID'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_system_competence]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_system_competence](
	[DatabaseCompetenceID] [int] IDENTITY(1,1) NOT NULL,
	[CompetenceID] [int] NOT NULL,
	[CompetenceName] [varchar](50) NOT NULL,
	[Description] [varchar](500) NOT NULL,
	[Is_Use] [int] NULL,
 CONSTRAINT [PK_T_SYSTEM_COMPETENCE] PRIMARY KEY NONCLUSTERED 
(
	[DatabaseCompetenceID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [uniq_competenceid] UNIQUE NONCLUSTERED 
(
	[CompetenceID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'权限ID' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_competence', @level2type=N'COLUMN', @level2name=N'DatabaseCompetenceID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'权限编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_competence', @level2type=N'COLUMN', @level2name=N'CompetenceID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'权限名称' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_competence', @level2type=N'COLUMN', @level2name=N'CompetenceName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'权限描述' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_competence', @level2type=N'COLUMN', @level2name=N'Description'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'启用标志：1-启用、2-未启用' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_competence', @level2type=N'COLUMN', @level2name=N'Is_Use'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'权限表' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_competence'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_talent_profession]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_talent_profession](
	[TalentProfessiondatabaseID] [int] IDENTITY(1,1) NOT NULL,
	[TalentProfessionID] [int] NOT NULL,
	[TalentProfessionName] [varchar](50) NOT NULL,
 CONSTRAINT [PK_T_TALENT_PROFESSION] PRIMARY KEY NONCLUSTERED 
(
	[TalentProfessiondatabaseID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'人才所属行业' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent_profession', @level2type=N'COLUMN', @level2name=N'TalentProfessionID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'行业类型名称' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent_profession', @level2type=N'COLUMN', @level2name=N'TalentProfessionName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'人才所属行业' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent_profession'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_tupi]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_tupi](
	[TupidatabaseID] [int] IDENTITY(1,1) NOT NULL,
	[TupiID] [int] NOT NULL,
	[TupiName] [varchar](50) NOT NULL,
 CONSTRAINT [PK_t_tupi] PRIMARY KEY NONCLUSTERED 
(
	[TupidatabaseID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'数据库ID' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_tupi', @level2type=N'COLUMN', @level2name=N'TupidatabaseID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'土地批准ID' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_tupi', @level2type=N'COLUMN', @level2name=N'TupiID'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_unit]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_unit](
	[DatabaseUnitID] [int] IDENTITY(1,1) NOT NULL,
	[UnitID] [int] NOT NULL,
	[UnitName] [varchar](50) NOT NULL,
	[Adress] [varchar](50) NOT NULL,
	[Phone] [varchar](20) NOT NULL,
 CONSTRAINT [PK_T_UNIT] PRIMARY KEY NONCLUSTERED 
(
	[DatabaseUnitID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'单位ID' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_unit', @level2type=N'COLUMN', @level2name=N'DatabaseUnitID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'单位编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_unit', @level2type=N'COLUMN', @level2name=N'UnitID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'单位名称' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_unit', @level2type=N'COLUMN', @level2name=N'UnitName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'单位地址' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_unit', @level2type=N'COLUMN', @level2name=N'Adress'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'联系电话' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_unit', @level2type=N'COLUMN', @level2name=N'Phone'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'单位信息' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_unit'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_degree]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_degree](
	[DegreedatabaseID] [int] IDENTITY(1,1) NOT NULL,
	[DegreeID] [int] NOT NULL,
	[DegreeName] [varchar](50) NOT NULL,
 CONSTRAINT [PK_t_degree] PRIMARY KEY CLUSTERED 
(
	[DegreedatabaseID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_nation]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_nation](
	[NationdatabaseID] [int] IDENTITY(1,1) NOT NULL,
	[NationID] [int] NOT NULL,
	[NationName] [varchar](50) NOT NULL,
 CONSTRAINT [PK_T_NATION] PRIMARY KEY NONCLUSTERED 
(
	[NationdatabaseID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'民族编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_nation', @level2type=N'COLUMN', @level2name=N'NationID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'民族名称' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_nation', @level2type=N'COLUMN', @level2name=N'NationName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'民族表' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_nation'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_admin_competence]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_admin_competence](
	[DatabaseAdminCompetence] [int] IDENTITY(1,1) NOT NULL,
	[AdminCompetenceID] [int] NOT NULL,
	[DatabaseAdminID] [int] NOT NULL,
	[DatabaseCompetenceID] [int] NULL,
 CONSTRAINT [PK_t_admin_competence] PRIMARY KEY NONCLUSTERED 
(
	[DatabaseAdminCompetence] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'数据库ID' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_admin_competence', @level2type=N'COLUMN', @level2name=N'DatabaseAdminCompetence'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'用户权限编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_admin_competence', @level2type=N'COLUMN', @level2name=N'AdminCompetenceID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'用户数据库ID' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_admin_competence', @level2type=N'COLUMN', @level2name=N'DatabaseAdminID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'权限ID' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_admin_competence', @level2type=N'COLUMN', @level2name=N'DatabaseCompetenceID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'用户权限表' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_admin_competence'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_people]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_people](
	[DatabasePeopleID] [int] IDENTITY(1,1) NOT NULL,
	[PeopleID] [int] NOT NULL,
	[PeopleName] [varchar](20) NULL,
	[DatabasePeoplesectorID] [int] NOT NULL,
	[Sex] [int] NULL,
	[Adress] [varchar](50) NULL,
	[Phone] [varchar](20) NULL,
	[CellPhone] [varchar](20) NULL,
 CONSTRAINT [PK_T_PEOPLE] PRIMARY KEY NONCLUSTERED 
(
	[DatabasePeopleID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'人员ID' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_people', @level2type=N'COLUMN', @level2name=N'DatabasePeopleID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'人员编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_people', @level2type=N'COLUMN', @level2name=N'PeopleID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'姓名' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_people', @level2type=N'COLUMN', @level2name=N'PeopleName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'所属部门' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_people', @level2type=N'COLUMN', @level2name=N'DatabasePeoplesectorID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'性别：1-男、2-女' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_people', @level2type=N'COLUMN', @level2name=N'Sex'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'办公地址' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_people', @level2type=N'COLUMN', @level2name=N'Adress'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'电话' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_people', @level2type=N'COLUMN', @level2name=N'Phone'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'人员表' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_people'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_system_admin]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_system_admin](
	[DatabaseAdminID] [int] IDENTITY(1,1) NOT NULL,
	[AdminID] [int] NOT NULL,
	[AdminName] [varchar](50) NULL,
	[AdminPassWord] [varchar](50) NULL,
	[Sex] [int] NULL,
	[TrueName] [varchar](50) NULL,
	[WorkNO] [varchar](50) NULL,
	[Email] [varchar](50) NULL,
	[MovePhone] [varchar](50) NULL,
	[Phone] [varchar](50) NULL,
	[MSN] [varchar](50) NULL,
	[RolesID] [int] NOT NULL,
	[SectorID] [int] NOT NULL,
	[Description] [varchar](500) NULL,
	[Address] [varchar](50) NULL,
	[Limit_Ip] [varchar](50) NULL,
	[Last_LoginTime] [datetime] NULL,
	[Last_LoginIp] [varchar](50) NULL,
	[Create_Time] [datetime] NULL,
	[Last_ModifyTime] [datetime] NULL,
	[Is_Use] [int] NULL,
	[Is_Del] [int] NULL,
	[Competence] [varchar](500) NULL,
 CONSTRAINT [PK_t_system_admin] PRIMARY KEY NONCLUSTERED 
(
	[DatabaseAdminID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'人员ID' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin', @level2type=N'COLUMN', @level2name=N'DatabaseAdminID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'人员编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin', @level2type=N'COLUMN', @level2name=N'AdminID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'帐号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin', @level2type=N'COLUMN', @level2name=N'AdminName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'密码' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin', @level2type=N'COLUMN', @level2name=N'AdminPassWord'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'性别：1-男、2-女' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin', @level2type=N'COLUMN', @level2name=N'Sex'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'姓名' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin', @level2type=N'COLUMN', @level2name=N'TrueName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'工号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin', @level2type=N'COLUMN', @level2name=N'WorkNO'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'联系EMAIL' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin', @level2type=N'COLUMN', @level2name=N'Email'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'移动电话' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin', @level2type=N'COLUMN', @level2name=N'MovePhone'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'电话' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin', @level2type=N'COLUMN', @level2name=N'Phone'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'角色编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin', @level2type=N'COLUMN', @level2name=N'RolesID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'部门编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin', @level2type=N'COLUMN', @level2name=N'SectorID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'人员描述' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin', @level2type=N'COLUMN', @level2name=N'Description'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'通讯地址' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin', @level2type=N'COLUMN', @level2name=N'Address'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'限定IP' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin', @level2type=N'COLUMN', @level2name=N'Limit_Ip'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'最后登录时间' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin', @level2type=N'COLUMN', @level2name=N'Last_LoginTime'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'最后登录IP' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin', @level2type=N'COLUMN', @level2name=N'Last_LoginIp'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'创建时间' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin', @level2type=N'COLUMN', @level2name=N'Create_Time'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'最后修改时间' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin', @level2type=N'COLUMN', @level2name=N'Last_ModifyTime'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'启用标志：1-启用、2-未启用' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin', @level2type=N'COLUMN', @level2name=N'Is_Use'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'是否删除：1-未删除、2-已删除' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin', @level2type=N'COLUMN', @level2name=N'Is_Del'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'拥有权限' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin', @level2type=N'COLUMN', @level2name=N'Competence'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'系统人员表' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_admin'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_peoplesector]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_peoplesector](
	[DatabasePeoplesectorID] [int] IDENTITY(1,1) NOT NULL,
	[PeopleSectorID] [int] NOT NULL,
	[PeopleSectorName] [varchar](50) NULL,
	[Adress] [varchar](50) NULL,
	[Phone] [varchar](20) NULL,
	[DatabaseUnitID] [int] NOT NULL,
 CONSTRAINT [PK_T_PEOPLESECTOR] PRIMARY KEY NONCLUSTERED 
(
	[DatabasePeoplesectorID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'部门ID' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_peoplesector', @level2type=N'COLUMN', @level2name=N'DatabasePeoplesectorID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'部门编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_peoplesector', @level2type=N'COLUMN', @level2name=N'PeopleSectorID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'部门名称' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_peoplesector', @level2type=N'COLUMN', @level2name=N'PeopleSectorName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'办公住址' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_peoplesector', @level2type=N'COLUMN', @level2name=N'Adress'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'电话' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_peoplesector', @level2type=N'COLUMN', @level2name=N'Phone'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'单位编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_peoplesector', @level2type=N'COLUMN', @level2name=N'DatabaseUnitID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'部门信息表' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_peoplesector'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_education]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_education](
	[EducationdatabaseID] [int] IDENTITY(1,1) NOT NULL,
	[EducationID] [int] NOT NULL,
	[EducationName] [varchar](50) NOT NULL,
 CONSTRAINT [PK_T_EDUCATION] PRIMARY KEY NONCLUSTERED 
(
	[EducationdatabaseID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'学历编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_education', @level2type=N'COLUMN', @level2name=N'EducationID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'学历名称' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_education', @level2type=N'COLUMN', @level2name=N'EducationName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'学历表' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_education'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_system_roles]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_system_roles](
	[DatabaseRolesID] [int] IDENTITY(1,1) NOT NULL,
	[RolesID] [int] NOT NULL,
	[RolesName] [varchar](50) NOT NULL,
	[Description] [varchar](500) NOT NULL,
	[Is_Use] [int] NULL,
	[CompetenceID] [varchar](500) NOT NULL,
 CONSTRAINT [PK_t_system_roles] PRIMARY KEY CLUSTERED 
(
	[DatabaseRolesID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'角色编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_roles', @level2type=N'COLUMN', @level2name=N'RolesID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'角色名称' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_roles', @level2type=N'COLUMN', @level2name=N'RolesName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'描述' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_roles', @level2type=N'COLUMN', @level2name=N'Description'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'启用标志：1-启用、2-未启用' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_roles', @level2type=N'COLUMN', @level2name=N'Is_Use'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'权限编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_roles', @level2type=N'COLUMN', @level2name=N'CompetenceID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'角色表' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_roles'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_major]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_major](
	[MajordatabaseID] [int] IDENTITY(1,1) NOT NULL,
	[MajorID] [int] NOT NULL,
	[MajorName] [varchar](50) NOT NULL,
 CONSTRAINT [PK_t_major] PRIMARY KEY NONCLUSTERED 
(
	[MajordatabaseID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [unq_major] UNIQUE NONCLUSTERED 
(
	[MajorID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'专业数据库编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_major', @level2type=N'COLUMN', @level2name=N'MajordatabaseID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'专业编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_major', @level2type=N'COLUMN', @level2name=N'MajorID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'专业名称' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_major', @level2type=N'COLUMN', @level2name=N'MajorName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'专业表' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_major'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_industry_project]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_industry_project](
	[DatabaseProjectID] [int] IDENTITY(1,1) NOT NULL,
	[ProjectID] [int] NOT NULL,
	[ProjectName] [varchar](50) NOT NULL,
	[DatabaseEnterpriseID] [int] NOT NULL,
	[ProQuality] [int] NOT NULL,
	[Address] [varchar](100) NULL,
	[CreateTime] [datetime] NULL,
	[plantime] [datetime] NULL,
	[CompleteTime] [datetime] NULL,
	[ProContent] [varchar](500) NULL,
	[planInvest] [float] NULL,
	[TotalInvest] [float] NULL,
	[RealInvest] [float] NULL,
	[yearinvest] [float] NULL,
	[publicinvest] [float] NULL,
	[selfinvest] [float] NULL,
	[bankloan] [float] NULL,
	[shb] [int] NULL,
	[hppf] [int] NULL,
	[tdpz] [int] NULL,
	[ghxz] [int] NULL,
	[shbno] [varchar](50) NULL,
	[hppfno] [varchar](50) NULL,
	[tdpzno] [varchar](50) NULL,
	[ghxzno] [varchar](50) NULL,
	[RegionID] [int] NOT NULL,
	[DutyUnitID] [int] NOT NULL,
	[IndustryID] [int] NOT NULL,
	[PlanProgress] [varchar](100) NULL,
	[RealProgress] [varchar](50) NULL,
	[Feature] [varchar](500) NULL,
	[State] [varchar](50) NULL,
	[linkman] [varchar](50) NULL,
	[phone] [varchar](20) NULL,
	[comment] [varchar](200) NULL,
	[Pic] [varchar](100) NULL,
	[DatabasePeopleID1] [int] NULL,
	[DatabasePeopleID2] [int] NULL,
	[AdminID] [int] NULL,
	[SectorID] [int] NULL,
	[LoginTime] [datetime] NULL,
 CONSTRAINT [PK_t_industry_project] PRIMARY KEY NONCLUSTERED 
(
	[DatabaseProjectID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [uni_projectid] UNIQUE NONCLUSTERED 
(
	[ProjectID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'项目ID' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'DatabaseProjectID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'项目编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'ProjectID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'项目名称' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'ProjectName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'经营单位' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'DatabaseEnterpriseID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'建设性质' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'ProQuality'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'所在地址' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'Address'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'创建时间' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'CreateTime'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'计划时间' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'plantime'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'完成时间' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'CompleteTime'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'项目内容' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'ProContent'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'计划投入资金' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'planInvest'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'实际投入资金' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'TotalInvest'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'本年投入资金' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'yearinvest'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'政府投资' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'publicinvest'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'自筹' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'selfinvest'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'银行' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'bankloan'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'审批,核准,备案' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'shb'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'环评批复' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'hppf'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'土地批准' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'tdpz'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'规划选址' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'ghxz'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'所属区域' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'RegionID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'主管单位' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'DutyUnitID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'产业类别' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'IndustryID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'计划进度' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'PlanProgress'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'实际进度' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'RealProgress'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'项目特色' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'Feature'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'经营状况' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'State'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'项目图片' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'Pic'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'填表人员' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'DatabasePeopleID1'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'统计人员' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'DatabasePeopleID2'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'登录人员' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'AdminID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'部门' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'SectorID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'登录时间' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project', @level2type=N'COLUMN', @level2name=N'LoginTime'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'文化项目表' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_project'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_cityinfo]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_cityinfo](
	[N_CityID] [int] IDENTITY(1,1) NOT NULL,
	[N_ParentID] [int] NULL DEFAULT ((0)),
	[C_CityName] [nvarchar](50) NULL DEFAULT (''),
	[N_OrderID] [int] NULL DEFAULT ((0)),
 CONSTRAINT [PK_T_CITYINFO] PRIMARY KEY NONCLUSTERED 
(
	[N_CityID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'城市id' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_cityinfo', @level2type=N'COLUMN', @level2name=N'N_CityID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'父id' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_cityinfo', @level2type=N'COLUMN', @level2name=N'N_ParentID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'城市名称' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_cityinfo', @level2type=N'COLUMN', @level2name=N'C_CityName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'排序id' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_cityinfo', @level2type=N'COLUMN', @level2name=N'N_OrderID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'城市' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_cityinfo'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_talent]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_talent](
	[databasetalentid] [int] IDENTITY(1,1) NOT NULL,
	[TalentID] [int] NOT NULL,
	[TalentName] [varchar](50) NULL,
	[Sex] [int] NULL,
	[Birthday] [datetime] NULL,
	[NationID] [int] NOT NULL,
	[NativePlace] [varchar](50) NULL,
	[PoliticsStatus] [varchar](50) NULL,
	[Province] [int] NULL,
	[CityID] [int] NULL,
	[EducationID] [int] NOT NULL,
	[DegreeID] [int] NOT NULL,
	[MajorID] [int] NOT NULL,
	[LearnExperience] [varchar](200) NULL,
	[WorkExperience] [varchar](200) NULL,
	[TalentProfessionID] [int] NOT NULL,
	[Acheivement] [varchar](200) NULL,
	[Honor] [varchar](200) NULL,
	[Skills] [varchar](200) NULL,
	[PostTitleID] [int] NOT NULL,
	[WorkUnit] [varchar](50) NULL,
	[Adress] [varchar](50) NULL,
	[MovePhone] [varchar](20) NULL,
	[Email] [varchar](50) NULL,
	[DatabasePeopleID1] [int] NULL,
	[DatabasePeopleID2] [int] NULL,
	[AdminID] [int] NULL,
	[SectorID] [int] NULL,
	[LoginTime] [datetime] NULL,
 CONSTRAINT [PK_t_talent] PRIMARY KEY NONCLUSTERED 
(
	[databasetalentid] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [uni_talentid] UNIQUE NONCLUSTERED 
(
	[TalentID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'人才编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'TalentID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'姓名' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'TalentName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'性别：1-男、2-女' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'Sex'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'出生日期' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'Birthday'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'民族' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'NationID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'籍贯' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'NativePlace'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'政治面貌' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'PoliticsStatus'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'省份' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'Province'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'城市' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'CityID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'学历' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'EducationID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'学位' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'DegreeID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'专业' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'MajorID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'个人学习经历' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'LearnExperience'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'工作经历' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'WorkExperience'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'人才所属行业' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'TalentProfessionID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'业绩' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'Acheivement'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'荣誉' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'Honor'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'专长' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'Skills'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'职称' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'PostTitleID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'工作单位' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'WorkUnit'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'现在住址' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'Adress'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'手机' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'MovePhone'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'邮箱' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'Email'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'统计人员' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'DatabasePeopleID1'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'填表人员' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'DatabasePeopleID2'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'登录人员' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'AdminID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'登录时间' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent', @level2type=N'COLUMN', @level2name=N'LoginTime'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'文化人才表' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_talent'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_enterprise]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_enterprise](
	[DatabaseEnterpriseID] [int] IDENTITY(1,1) NOT NULL,
	[EnterpriseID] [int] NOT NULL,
	[EnterpriseName] [varchar](50) NULL,
	[BusinessTypeID] [int] NOT NULL,
	[LegalPerson] [varchar](50) NULL,
	[CreateTime] [datetime] NULL,
	[RegionID] [int] NOT NULL,
	[Address] [varchar](50) NULL,
	[EnterpriseCode] [varchar](50) NULL,
	[PartentCode] [varchar](50) NULL,
	[Scope] [varchar](50) NULL,
	[RegistAddress] [varchar](50) NULL,
	[RegistFund] [float] NULL,
	[Area] [int] NULL,
	[ToalInvest] [float] NULL,
	[QualityID] [int] NOT NULL,
	[EmployNumber] [int] NULL,
	[ProduceValue] [float] NULL,
	[Profit] [float] NULL,
	[Feature] [varchar](500) NULL,
	[ObtainHonor] [varchar](500) NULL,
	[SocialBenefit] [varchar](500) NULL,
	[PeopleID1] [int] NULL,
	[PeopleID2] [int] NULL,
	[AdminID] [int] NULL,
	[SectorID] [int] NULL,
	[LoginTime] [datetime] NULL,
	[LinkPhone] [varchar](50) NULL,
	[contact] [varchar](50) NULL,
 CONSTRAINT [PK_t_enterprise] PRIMARY KEY NONCLUSTERED 
(
	[DatabaseEnterpriseID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'企业ID' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'DatabaseEnterpriseID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'企业编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'EnterpriseID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'企业名称' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'EnterpriseName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'行业类型' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'BusinessTypeID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'法人' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'LegalPerson'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'创立时间' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'CreateTime'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'所属区域' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'RegionID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'企业地址' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'Address'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'工商登记号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'EnterpriseCode'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'产品专利号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'PartentCode'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'经营范围' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'Scope'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'企业注册地址' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'RegistAddress'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'注册资金' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'RegistFund'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'占地面积' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'Area'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'总投资' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'ToalInvest'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'企业性质' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'QualityID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'就业人数' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'EmployNumber'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'年产值' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'ProduceValue'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'利润' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'Profit'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'产品特色' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'Feature'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'获得荣誉' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'ObtainHonor'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'社会效益' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'SocialBenefit'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'统计人员' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'PeopleID1'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'填表人员' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'PeopleID2'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'登录人员' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'AdminID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'部门编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'SectorID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'登录时间' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'LoginTime'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'联系电话' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'LinkPhone'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'联系人' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise', @level2type=N'COLUMN', @level2name=N'contact'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'企业信息表' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprise'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_roles_competence]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_roles_competence](
	[DatabaseRoseCompetenceID] [int] IDENTITY(1,1) NOT NULL,
	[RolesID] [int] NOT NULL,
	[CompetenceID] [int] NOT NULL,
 CONSTRAINT [PK_ROLES_COMPETENCE] PRIMARY KEY NONCLUSTERED 
(
	[DatabaseRoseCompetenceID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'角色权限ID' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_roles_competence', @level2type=N'COLUMN', @level2name=N'DatabaseRoseCompetenceID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'角色ID' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_roles_competence', @level2type=N'COLUMN', @level2name=N'RolesID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'权限编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_roles_competence', @level2type=N'COLUMN', @level2name=N'CompetenceID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'角色权限表' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_roles_competence'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_dictionary]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_dictionary](
	[DictionaryId] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](50) NOT NULL,
	[TableName] [varchar](50) NOT NULL,
	[IsUse] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[DictionaryId] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'显示名称' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_dictionary', @level2type=N'COLUMN', @level2name=N'Name'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'对应表名' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_dictionary', @level2type=N'COLUMN', @level2name=N'TableName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'是否启用' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_dictionary', @level2type=N'COLUMN', @level2name=N'IsUse'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_industry_type]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_industry_type](
	[IndustrydatabaseID] [int] IDENTITY(1,1) NOT NULL,
	[IndustryID] [int] NOT NULL,
	[IndustryName] [varchar](50) NULL,
 CONSTRAINT [PK_T_INDUSTRY_TYPE] PRIMARY KEY NONCLUSTERED 
(
	[IndustrydatabaseID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'产业项目类别编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_type', @level2type=N'COLUMN', @level2name=N'IndustryID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'产业项目类别名称' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_type', @level2type=N'COLUMN', @level2name=N'IndustryName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'产业项目类别类别表' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_type'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_industry_foundtype]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_industry_foundtype](
	[FundTypeID] [int] IDENTITY(1,1) NOT NULL,
	[FundTypeName] [varchar](50) NULL,
	[Description] [varchar](500) NULL,
 CONSTRAINT [PK_T_INDUSTRY_FOUNDTYPE] PRIMARY KEY NONCLUSTERED 
(
	[FundTypeID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'资金类别编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_foundtype', @level2type=N'COLUMN', @level2name=N'FundTypeID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'资金类别名' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_foundtype', @level2type=N'COLUMN', @level2name=N'FundTypeName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'描述' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_foundtype', @level2type=N'COLUMN', @level2name=N'Description'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'资金类别表' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_foundtype'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_industry_founsource]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_industry_founsource](
	[FoundSourceID] [int] IDENTITY(1,1) NOT NULL,
	[FoundSourceName] [varchar](50) NULL,
	[Description] [varchar](500) NULL,
 CONSTRAINT [PK_T_INDUSTRY_FOUNSOURCE] PRIMARY KEY NONCLUSTERED 
(
	[FoundSourceID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'资金来源编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_founsource', @level2type=N'COLUMN', @level2name=N'FoundSourceID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'资金来源名' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_founsource', @level2type=N'COLUMN', @level2name=N'FoundSourceName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'描述' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_founsource', @level2type=N'COLUMN', @level2name=N'Description'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'资金来源表' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_founsource'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_system_sector]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_system_sector](
	[SectordatabaseID] [int] IDENTITY(1,1) NOT NULL,
	[SectorID] [int] NULL,
	[SectorName] [varchar](50) NULL,
	[Description] [varchar](500) NULL,
	[Address] [varchar](50) NULL,
	[Phone] [varchar](20) NULL,
	[Is_Use] [int] NULL,
	[Is_Del] [int] NULL,
	[DatabaseUnitID] [varchar](50) NULL,
	[sorts] [float] NULL,
 CONSTRAINT [PK_T_SYSTEM_SECTOR] PRIMARY KEY NONCLUSTERED 
(
	[SectordatabaseID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [uni_sectorid] UNIQUE NONCLUSTERED 
(
	[SectorID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'部门编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_sector', @level2type=N'COLUMN', @level2name=N'SectordatabaseID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'部门编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_sector', @level2type=N'COLUMN', @level2name=N'SectorID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'部门名称' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_sector', @level2type=N'COLUMN', @level2name=N'SectorName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'部门描述' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_sector', @level2type=N'COLUMN', @level2name=N'Description'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'启用标志：1-启用、2-未启用' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_sector', @level2type=N'COLUMN', @level2name=N'Is_Use'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'是否删除：1-未删除、2-已删除' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_sector', @level2type=N'COLUMN', @level2name=N'Is_Del'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'排序' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_sector', @level2type=N'COLUMN', @level2name=N'sorts'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'部门表' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_system_sector'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_age]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_age](
	[AgedatabaseID] [int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	[AgeID] [int] NOT NULL,
	[AgeName] [varchar](50) NOT NULL,
 CONSTRAINT [PK_T_AGE] PRIMARY KEY NONCLUSTERED 
(
	[AgedatabaseID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [unq_age] UNIQUE NONCLUSTERED 
(
	[AgeID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'年龄段编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_age', @level2type=N'COLUMN', @level2name=N'AgeID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_age', @level2type=N'COLUMN', @level2name=N'AgeName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'年龄段表' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_age'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_enterprist_quality]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_enterprist_quality](
	[QualitydatabaseID] [int] IDENTITY(1,1) NOT NULL,
	[QualityID] [varchar](50) NOT NULL,
	[QualityName] [varchar](50) NOT NULL,
 CONSTRAINT [PK_T_ENTERPRIST_QUALITY] PRIMARY KEY NONCLUSTERED 
(
	[QualitydatabaseID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [uni_quality] UNIQUE NONCLUSTERED 
(
	[QualityID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'企业性质编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprist_quality', @level2type=N'COLUMN', @level2name=N'QualitydatabaseID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'企业性质名称' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprist_quality', @level2type=N'COLUMN', @level2name=N'QualityName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'企业性质表' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_enterprist_quality'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_system_parameter]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_system_parameter](
	[DatabaseID] [int] IDENTITY(1,1) NOT NULL,
	[UnitName] [varchar](50) NULL,
	[Dept] [varchar](50) NULL,
	[Address] [varchar](50) NULL
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_huanpi]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_huanpi](
	[HuanpidatabaseID] [int] IDENTITY(1,1) NOT NULL,
	[HuanpiID] [int] NOT NULL,
	[HuanpiName] [varchar](50) NOT NULL,
 CONSTRAINT [PK_t_huanpi] PRIMARY KEY NONCLUSTERED 
(
	[HuanpidatabaseID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'数据库ID' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_huanpi', @level2type=N'COLUMN', @level2name=N'HuanpidatabaseID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'环境批复ID' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_huanpi', @level2type=N'COLUMN', @level2name=N'HuanpiID'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_industry_dutyunit]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[t_industry_dutyunit](
	[DutyUnitID] [int] IDENTITY(1,1) NOT NULL,
	[DutyUnitName] [varchar](50) NOT NULL,
	[Linkman] [varchar](50) NOT NULL,
	[Telphone] [varchar](20) NOT NULL,
 CONSTRAINT [PK_T_INDUSTRY_DUTYUNIT] PRIMARY KEY NONCLUSTERED 
(
	[DutyUnitID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'责主管位编号' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_dutyunit', @level2type=N'COLUMN', @level2name=N'DutyUnitID'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'主管单位名' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_dutyunit', @level2type=N'COLUMN', @level2name=N'DutyUnitName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'联系人' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_dutyunit', @level2type=N'COLUMN', @level2name=N'Linkman'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'联系电话' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_dutyunit', @level2type=N'COLUMN', @level2name=N'Telphone'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'主管单位表' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N't_industry_dutyunit'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[talent_age_statistics]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'
CREATE procedure [dbo].[talent_age_statistics] 
@MaxAge int ,--最大年龄
@MinAge int  --最小年龄
as select count(*) as total from (select talentID, datediff(year,Birthday,getdate()) ''age'' from t_talent) as a where a.age>=@MinAge and a.age<=@MaxAge
' 
END
