workspace(name = "nlp-test")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

#####################
#     CONSTANTS     #
#####################

# Scala 2.12 commit from bazelbuild/rules_scala
RULES_SCALA_VERSION = "182d02142224d58b60d54fd4b5f286cbf8b19fe9"

#################
#     RULES     #
#################

http_archive(
    name = "rules_proto",
    sha256 = "8e7d59a5b12b233be5652e3d29f42fba01c7cbab09f6b3a8d0a57ed6d1e9a0da",
    strip_prefix = "rules_proto-7e4afce6fe62dbff0a4a03450143146f9f2d7488",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/rules_proto/archive/7e4afce6fe62dbff0a4a03450143146f9f2d7488.tar.gz",
        "https://github.com/bazelbuild/rules_proto/archive/7e4afce6fe62dbff0a4a03450143146f9f2d7488.tar.gz",
    ],
)

http_archive(
    name = "io_bazel_rules_scala",
    sha256 = "7075ab4fa8cce8be77e263bfcd760ccda8645152d9af8c33b5053dce507ce322",
    strip_prefix = "rules_scala-%s" % RULES_SCALA_VERSION,
    type = "zip",
    url = "https://github.com/bazelbuild/rules_scala/archive/%s.zip" % RULES_SCALA_VERSION,
)

http_archive(
    name = "rules_jvm_external",
    sha256 = "d85951a92c0908c80bd8551002d66cb23c3434409c814179c0ff026b53544dab",
    strip_prefix = "rules_jvm_external-3.3",
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/3.3.zip",
)

###################
#     PROTOBUF    #
###################

load("@rules_proto//proto:repositories.bzl", "rules_proto_dependencies", "rules_proto_toolchains")

rules_proto_dependencies()

rules_proto_toolchains()

################
#     SCALA    #
################

load("@io_bazel_rules_scala//:scala_config.bzl", "scala_config")

scala_config(scala_version = "2.12.13")

load("@io_bazel_rules_scala//scala:scala.bzl", "scala_repositories")

scala_repositories()

load("@io_bazel_rules_scala//scala:toolchains.bzl", "scala_register_toolchains")

scala_register_toolchains()

########################
#     DEPENDENCIES     #
########################

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    name = "maven",
    artifacts = [
        "com.johnsnowlabs.nlp:spark-nlp_2.12:3.1.3",
        "org.apache.spark:spark-catalyst_2.12:3.1.2",
        "org.apache.spark:spark-core_2.12:3.1.2",
        "org.apache.spark:spark-mllib-local_2.12:3.1.2",
        "org.apache.spark:spark-mllib_2.12:3.1.2",
        "org.apache.spark:spark-sql_2.12:3.1.2",
        "org.apache.spark:spark-tags_2.12:3.1.2",
    ],
    fail_on_missing_checksum = False,
    generate_compat_repositories = True,
    repositories = [
        "https://maven.google.com",
        "https://repo1.maven.org/maven2",
    ],
)

load("@maven//:compat.bzl", "compat_repositories")

compat_repositories()
