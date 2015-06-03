#!/usr/bin/env perl

use strict;
use warnings;
use utf8;
use Encode qw/encode_utf8/;
use Lingua::JA::Kana qw/katakana2hiragana/;
use Text::CSV_XS;
use YAML::Tiny;

my $dict_file = $ARGV[0] or die "You must specify dict file";

my @rows;
my $csv = Text::CSV_XS->new ({ binary => 1, auto_diag => 1 });
open my $frh, '<:encoding(utf8)', $dict_file or die $!;
while (my $row = $csv->getline($frh)) {
    if ($row->[4] eq '名詞' && ($row->[5] eq '一般' || $row->[5] eq '固有名詞')) {
        push @rows, [$row->[0], katakana2hiragana($row->[11]), $row->[11]];
    }
}

my $size = scalar @rows;

my @nouns;
while (scalar @nouns < 10000) {
    my $index = int rand $size;
    my $row = $rows[$index];
    if ($row) {
        push @nouns, $row;
        $rows[$index] = undef;
    }
}

print encode_utf8(Dump({ nouns => [@nouns] }));

